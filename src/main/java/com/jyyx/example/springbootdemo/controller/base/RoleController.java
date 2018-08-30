package com.jyyx.example.springbootdemo.controller.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.base.Role;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private BasePermissionService basePermissionService;

    @RequestMapping(value = "goRoleList")
    public String goRoleList(
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
        List<Role> roleList = roleService.queryRoleList(paramSet);
        PageInfo<Role> p = new PageInfo<Role>(roleList);
        //分页
        map.put("page",p);
        //访问权限
        map.put("permission",flag);
        //操作权限
        map.put("doPermission",doPermission);
        map.put("roleList",roleList);
        return "base/role";
    }

    @RequestMapping(value="/getRoleList")
    @ResponseBody
    List<Role> getRoleList() throws Exception{
        return   roleService.queryRoleList(new HashMap<>());
    }


    /**
     * 保存新增或修改
     * @param roleId
     * @param roleName
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "saveRole")
    @ResponseBody
    public Response saveRole(
            @RequestParam(value ="roleId")String roleId,
            @RequestParam(value = "roleName")String roleName
    )throws Exception{
        Role role = new Role();
        role.setId(roleId);
        role.setRoleName(roleName);
        if(roleService.addOrEditRole(role) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }
        return new Response(ExceptionMsg.FAILED);
    }

    /**
     * 根据id查出单条角色数据
     * @param roleId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryRoleById")
    @ResponseBody
    Role queryRoleById(
            @RequestParam(value="roleId")String roleId
    )throws Exception{
        Role role = roleService.queryRoleById(roleId);
        return role;
    }

    /**
     * 根据角色id删除
     */
    @RequestMapping(value = "deleteByRoleId")
    @ResponseBody
    Response deleteByRoleId(
            @RequestParam(value="roleId")String roleId
    )throws Exception{
        if(roleService.deleteById(roleId) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }

}
