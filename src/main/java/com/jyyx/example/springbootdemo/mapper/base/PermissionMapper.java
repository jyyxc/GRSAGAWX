package com.jyyx.example.springbootdemo.mapper.base;

import com.jyyx.example.springbootdemo.entity.base.Permission;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface PermissionMapper extends MyMapper<Permission> {

    Permission queryPermissionById(String permissionId);
    List<Permission> queryPermissionList(HashMap<String,Object> paramSet);
    int deleteById(String permissionId);
}
