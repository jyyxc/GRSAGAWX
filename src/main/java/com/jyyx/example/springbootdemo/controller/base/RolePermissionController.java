package com.jyyx.example.springbootdemo.controller.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.base.ERole;
import com.jyyx.example.springbootdemo.entity.base.RolePermission;
import com.jyyx.example.springbootdemo.entity.base.RPermission;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.base.EmployeeRoleService;
import com.jyyx.example.springbootdemo.service.base.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "rolepermission")
public class RolePermissionController {

    @Autowired
    private RolePermissionService rolePermissionService;

    @Autowired
    private BasePermissionService basePermissionService;

    @RequestMapping(value = "goRolePermissionList")
    public String goRolePermissionList(
            HashMap<String,Object> map,
            HttpServletRequest request,
            @RequestParam(value = "page",defaultValue = "1") int page,
            @RequestParam(value = "keyword",defaultValue = "")String keyword
    ) throws Exception {
        //定义查询参数map
        HashMap<String,Object> paramSet = new HashMap<>();
        paramSet.put("page",page);
        paramSet.put("keyword",keyword);
        //拿到访问路径uri
        String uri = request.getRequestURI();
        //拿到权限返回的map集合
        HashMap<String,Object> resultMap = basePermissionService.queryPermissionByOpenId(CoreUtil.open_id,uri);
        //如果flag==true  返回yes  否则返回no
        String flag = (Boolean)resultMap.get("urlPermission") ? "yes" : "no";
        String doPermission = resultMap.get("doPermission").toString();
        //开始分页
        PageHelper.startPage(page,10);
        //员工数据
        List<RPermission> rolePermissionList = rolePermissionService.queryRPermissionList(paramSet);
        PageInfo<RPermission> p = new PageInfo<RPermission>(rolePermissionList);
        //分页
        map.put("page",p);
        //访问权限
        map.put("permission",flag);
        //操作权限
        map.put("doPermission",doPermission);
        map.put("rolePermissionList",rolePermissionList);
        return "base/rolepermission";
    }


    /**
     * 保存新增或修改
     * @param roleId
     * @param permissionIds
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveRolePermission")
    @ResponseBody
    public Response saveRolePermission(
            @RequestParam(value ="roleId")String roleId,
            @RequestParam(value = "permissionIds")String permissionIds
    )throws Exception{
        //先查询需要分配权限的角色原先的权限
        List<RPermission> rPermissionList = rolePermissionService.queryRolePermissionListByRoleId(roleId);
        if(rPermissionList != null && rPermissionList.size() > 0 )
//            先清空原有关联角色 再重新添加角色
            rolePermissionService.deleteByRoleId(roleId);
        //分割id字符串 循环添加
        int result = 0;
        String[] ids = permissionIds.split(",");
        boolean flag = false;
        for(String id:ids){
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermissionId(id);
            rolePermission.setRoleId(roleId);
            rolePermission.setDoPermission(0);
            result += rolePermissionService.addOrEditRolePermission(rolePermission);
        }
        if(result >= ids.length) {
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }

    /**
     * 根据id查出单条角色数据
     * @param rolePermissionId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryRolePermissionById")
    @ResponseBody
    List<RPermission> queryRolePermissionById(
            @RequestParam(value="rolePermissionId")String rolePermissionId
    )throws Exception{
        RolePermission rolePermission = rolePermissionService.queryRolePermissionById(rolePermissionId);
        List<RPermission> rPermissionList = rolePermissionService.queryRolePermissionListByRoleId(rolePermission.getRoleId());
        return rPermissionList;
    }

    /**
     * 根据关联表id删除
     */
    @RequestMapping(value = "deleteByRolePermissionId")
    @ResponseBody
    Response deleteByRolePermissionId(
            @RequestParam(value="rolePermissionId")String rolePermissionId
    )throws Exception{
        if(rolePermissionService.deleteByRolePermissionId(rolePermissionId) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }

    /**
     * 修改操作权限状态
     */
    @RequestMapping(value = "changeDoPermissionByRolePermissionId")
    @ResponseBody
    Response changeDoPermissionByRolePermissionId(
            @RequestParam(value="rolePermissionId")String rolePermissionId,
            @RequestParam(value="doPermission")int doPermission
    )throws Exception{
        RolePermission rolePermission = new RolePermission();
        rolePermission.setId(rolePermissionId);
        if(doPermission == 0){
            rolePermission.setDoPermission(1);
        }else{
            rolePermission.setDoPermission(0);
        }
        if(rolePermissionService.changeDoPermissionByRolePermissionId(rolePermission) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }

}
