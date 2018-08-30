package com.jyyx.example.springbootdemo.controller.base;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jyyx.example.springbootdemo.domain.ExceptionMsg;
import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.base.Permission;
import com.jyyx.example.springbootdemo.entity.weixin.util.CoreUtil;
import com.jyyx.example.springbootdemo.service.BasePermissionService;
import com.jyyx.example.springbootdemo.service.base.PermissionService;
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
@RequestMapping(value="/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private BasePermissionService basePermissionService;



    @RequestMapping(value = "goPermissionList")
    public String goPermissionList(
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
        Object storeId = resultMap.get("storeId");
        String flag = (Boolean)resultMap.get("urlPermission") ? "yes" : "no";
        String doPermission = resultMap.get("doPermission").toString();
        //开始分页
        PageHelper.startPage(page,10);
        //员工数据
        List<Permission> permissionList = permissionService.queryPermissionList(paramSet);
        PageInfo<Permission> p = new PageInfo<Permission>(permissionList);
        //分页
        map.put("page",p);
        //访问权限
        map.put("permission",flag);
        //操作权限
        map.put("doPermission",doPermission);
        map.put("permissionList",permissionList);
        if(storeId != null && !"".equals(storeId.toString()))
            map.put("storeId",storeId.toString());
        return "base/permission";
    }

    @RequestMapping(value="/getPermissionList")
    @ResponseBody
    List<Permission> getPermissionList() throws Exception{
        return   permissionService.queryPermissionList(new HashMap<>());
    }



    @RequestMapping(value = "savePermission")
    @ResponseBody
    public Response savePermission(
            @RequestParam(value ="permissionId")String permissionId,
            @RequestParam(value = "permissionName")String permissionName,
            @RequestParam(value = "uri")String uri
    )throws Exception{
        Permission permission = new Permission();
        permission.setId(permissionId);
        permission.setPermissionName(permissionName);
        permission.setUri(uri);
//        permissionService.addOrEditPermission(permission);
        if(permissionService.addOrEditPermission(permission) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }
        return new Response(ExceptionMsg.FAILED);
    }

    /**
     * 根据id查出单条权限数据
     * @param permissionId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "queryPermissionById")
    @ResponseBody
    Permission queryPermissionById(
            @RequestParam(value="permissionId")String permissionId
    )throws Exception{
        Permission permission = permissionService.queryPermissionById(permissionId);
        return permission;
    }

    /**
     * 根据权限id删除
     */
    @RequestMapping(value = "deleteByPermissionId")
    @ResponseBody
    Response deleteByPermissionId(
            @RequestParam(value="permissionId")String permissionId
    )throws Exception{
        if(permissionService.deleteById(permissionId) >= 1){
            return new Response(ExceptionMsg.SUCCESS);
        }else{
            return new Response(ExceptionMsg.FAILED);
        }
    }
}
