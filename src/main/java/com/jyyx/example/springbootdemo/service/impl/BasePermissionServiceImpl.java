package com.jyyx.example.springbootdemo.service.impl;

import com.jyyx.example.springbootdemo.entity.hr.Employee;
import com.jyyx.example.springbootdemo.entity.base.EmployeeRole;
import com.jyyx.example.springbootdemo.entity.base.RPermission;
import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.base.EmployeeRoleService;
import com.jyyx.example.springbootdemo.service.hr.EmployeeService;
import com.jyyx.example.springbootdemo.service.base.RolePermissionService;
import com.jyyx.example.springbootdemo.service.base.RoleService;
import com.jyyx.example.springbootdemo.service.weixin.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Service
public class BasePermissionServiceImpl implements BasePermissionService {


    @Autowired
    private WxService wxService;


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeRoleService employeeRoleService;


    @Autowired
    private RolePermissionService rolePermissionService;

    @Override
    public HashMap<String, Object> queryPermissionByOpenId(String openId, String uri) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();
        //设定开关默认为false
        boolean flag = false;
        //默认没有操作权限
        int doPermission = 1 ;
        //定义一个权限集合
        List<RPermission> permissionList = new ArrayList<>();
        //权限 首先根据微信openid查出微信用户
        WxUser wxUser = wxService.queryWxUserByOpenId(openId);
        if(wxUser != null) {
            //根据employeeid查出当前登录角色的员工信息
            Employee employee = employeeService.queryEmployeeById(wxUser.getEmployeeId());
            if(employee.getStatus() != 1 && employee.getStatus() != 2) {
                //如果微信用户不等于空 根据employeeid 查出当前账号下的角色
                if (wxUser != null) {
                    List<EmployeeRole> employeeRoleList = employeeRoleService.queryRoleListByEmployeeId(wxUser.getEmployeeId());

                    //如果角色不为空 根据角色查出该角色下所有权限
                    if (employeeRoleList != null && employeeRoleList.size() > 0) {
                        //根据角色id查出权限列表
                        for (EmployeeRole r : employeeRoleList) {
                            List<RPermission> permissions = rolePermissionService.queryRolePermissionList(r.getRoleId());
                            //主集合里去掉跟副集合重复的数据
                            permissionList.removeAll(permissions);
                            //合并两个集合
                            permissionList.addAll(permissions);
                            permissionList = new ArrayList<RPermission>(new HashSet<>(permissionList));
                        }
                        for (RPermission p : permissionList) {
                            if (uri.equals(p.getUri())) {
                                flag = true;
                                doPermission = p.getDoPermission();
                            }
                        }
                        resultMap.put("urlPermission", flag);
                        resultMap.put("doPermission", doPermission);
                        resultMap.put("storeId", employee.getStoreId());
                        resultMap.put("storeName", employee.getStoreName());
                    }
                    return resultMap;
                }
            }
        }
        resultMap.put("doPermission", doPermission);
        resultMap.put("urlPermission", flag);
        return resultMap;
    }
}