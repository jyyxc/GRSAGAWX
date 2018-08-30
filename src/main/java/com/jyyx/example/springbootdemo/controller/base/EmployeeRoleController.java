package com.jyyx.example.springbootdemo.controller.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.base.ERole;
import com.jyyx.example.springbootdemo.entity.base.EmployeeRole;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.base.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "employeerole")
public class EmployeeRoleController {

    @Autowired
    private EmployeeRoleService employeeRoleService;

    @Autowired
    private BasePermissionService basePermissionService;

    @RequestMapping(value = "goEmployeeRoleList")
    public String goEmployeeRoleList(
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
        List<ERole> employeeRoleList = employeeRoleService.queryEmployeeRoleList(paramSet);
        PageInfo<ERole> p = new PageInfo<ERole>(employeeRoleList);
        //分页
        map.put("page",p);
        //访问权限
        map.put("permission",flag);
        //操作权限
        map.put("doPermission",doPermission);
        map.put("employeeRoleList",employeeRoleList);
        return "base/employeerole";
    }

    /**
     * 保存新增或修改
     * @param roleIds
     * @param employeeId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveEmployeeRole")
    @ResponseBody
    public Response saveEmployeeRole(
            @RequestParam(value ="roleIds")String roleIds,
            @RequestParam(value = "employeeId")String employeeId
    )throws Exception{
//        roleIds = roleIds.substring(0,roleIds.length()-10);
        //先查询需要分配角色的员工原先是否有角色
        List<ERole> eRoleList = employeeRoleService.queryEmployeeRoleListByEmployeeId(employeeId);
        if(eRoleList != null && eRoleList.size() > 0 )
        //先清空原有关联角色 再重新添加角色
        employeeRoleService.deleteByEmployeeId(employeeId);
        //分割id字符串 循环添加
        int result = 0;
        String[] ids = roleIds.split(",");
        for(String id : ids){
            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setEmployeeId(employeeId);
            employeeRole.setRoleId(id);
            result = result + employeeRoleService.addOrEditEmployeeRole(employeeRole);
        }
        if(result >= ids.length) {
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }

    /**
     * 根据id查出单条角色数据
     * @param employeeRoleId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryEmployeeRoleById")
    @ResponseBody
    List<ERole> queryEmployeeRoleById(
            @RequestParam(value="employeeRoleId")String employeeRoleId
    )throws Exception{
        EmployeeRole employeeRole = employeeRoleService.queryEmployeeRoleById(employeeRoleId);
        List<ERole> eRoleList =employeeRoleService.queryEmployeeRoleListByEmployeeId(employeeRole.getEmployeeId());
        return eRoleList;
    }

    /**
     * 根据关联表id删除
     */
    @RequestMapping(value = "deleteByEmployeeRoleId")
    @ResponseBody
    Response deleteByEmployeeRoleId(
            @RequestParam(value="employeeRoleId")String employeeRoleId
    )throws Exception{
        if(employeeRoleService.deleteByEmployeeRoleId(employeeRoleId) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }

}
