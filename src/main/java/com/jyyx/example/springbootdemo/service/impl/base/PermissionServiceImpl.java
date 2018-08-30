package com.jyyx.example.springbootdemo.service.impl.base;

import com.jyyx.example.springbootdemo.entity.base.Permission;
import com.jyyx.example.springbootdemo.mapper.base.PermissionMapper;
import com.jyyx.example.springbootdemo.service.base.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public int addOrEditPermission(Permission permission) throws Exception {
        if(permission.getId() != null && !"".equals(permission.getId())){
            //说明是修改
            Permission newp =permissionMapper.queryPermissionById(permission.getId());
            newp.setPermissionName(permission.getPermissionName());
            newp.setUri(permission.getUri());
            newp.setEditDate(new Date());
            return permissionMapper.updateByPrimaryKey(newp);
        }else {
            permission.setIsDeleted(0);
            permission.setCreateDate(new Date());
            return permissionMapper.insert(permission);
        }
    }

    @Override
    public Permission queryPermissionById(String permissionId) throws Exception {
        Permission permission = permissionMapper.queryPermissionById(permissionId);
        return permission;
    }

    @Override
    public List<Permission> queryPermissionList(HashMap<String,Object> paramSet) throws Exception {
        List<Permission> permissionList = permissionMapper.queryPermissionList(paramSet);
        return permissionList;
    }

    @Override
    public int deleteById(String permissionId) throws Exception {
        return permissionMapper.deleteById(permissionId);
    }


}
