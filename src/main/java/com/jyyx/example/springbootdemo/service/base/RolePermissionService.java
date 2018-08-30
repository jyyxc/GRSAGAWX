package com.jyyx.example.springbootdemo.service.base;

import com.jyyx.example.springbootdemo.entity.base.RolePermission;
import com.jyyx.example.springbootdemo.entity.base.RPermission;

import java.util.HashMap;
import java.util.List;

public interface RolePermissionService {
    List<RPermission> queryRolePermissionList(String roleId)throws Exception;
    int addOrEditRolePermission(RolePermission rolePermission)throws Exception;
    List<RolePermission> queryPermissionListByRoleId(String  roleId)throws Exception;
    List<RPermission> queryRPermissionList(HashMap<String,Object> paramSet)throws Exception;
    int deleteByRolePermissionId(String rolePermissionId)throws Exception;
    int deleteByRoleId(String roleId)throws Exception;
    RolePermission queryRolePermissionById(String roleId)throws Exception;
    List<RPermission> queryRolePermissionListByRoleId(String roleId)throws Exception;
    int changeDoPermissionByRolePermissionId(RolePermission rolePermission)throws Exception;
}
