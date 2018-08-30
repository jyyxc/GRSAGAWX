package com.jyyx.example.springbootdemo.service.base;

import com.jyyx.example.springbootdemo.entity.base.Permission;

import java.util.HashMap;
import java.util.List;

public interface PermissionService {
    int addOrEditPermission(Permission permission)throws Exception;
    Permission queryPermissionById(String permissionId)throws Exception;
    List<Permission> queryPermissionList(HashMap<String,Object> paramSet)throws Exception;
    int deleteById(String permissionId)throws Exception;
}
