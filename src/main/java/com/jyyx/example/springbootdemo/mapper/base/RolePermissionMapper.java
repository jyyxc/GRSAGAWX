package com.jyyx.example.springbootdemo.mapper.base;

import com.jyyx.example.springbootdemo.entity.base.Permission;
import com.jyyx.example.springbootdemo.entity.base.RolePermission;
import com.jyyx.example.springbootdemo.entity.base.RPermission;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface RolePermissionMapper extends MyMapper<RolePermission> {
    //用Permission对象装载关联查询后的数据
    List<RPermission> queryRolePermissionList(String roleId);

    //根据角色id查询 当前角色下所有权限
    List<RolePermission> queryPermissionListByRoleId(String roleId);
    List<RPermission> queryRPermissionList(HashMap<String,Object> paramSet);
    int deleteByRolePermissionId(String rolePermissionId);
    int deleteByRoleId(String roleId);
    RolePermission queryRolePermissionById(String rolePermissionId);
    List<RPermission> queryRolePermissionListByRoleId(String roleId);
    int changeDoPermissionByRolePermissionId(RolePermission rolePermission);

}