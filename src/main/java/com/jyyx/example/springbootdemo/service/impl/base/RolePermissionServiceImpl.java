package com.jyyx.example.springbootdemo.service.impl.base;

import com.jyyx.example.springbootdemo.entity.base.RolePermission;
import com.jyyx.example.springbootdemo.entity.base.RPermission;
import com.jyyx.example.springbootdemo.mapper.base.RolePermissionMapper;
import com.jyyx.example.springbootdemo.service.base.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RPermission> queryRolePermissionList(String roleId) throws Exception {
        return rolePermissionMapper.queryRolePermissionList(roleId);
    }

    @Override
    public int addOrEditRolePermission(RolePermission rolePermission) throws Exception {
        rolePermission.setCreateDate(new Date());
        rolePermission.setIsDeleted(0);
        return rolePermissionMapper.insert(rolePermission);
    }

    @Override
    public List<RolePermission> queryPermissionListByRoleId(String roleId) throws Exception {
        return rolePermissionMapper.queryPermissionListByRoleId(roleId);
    }

    @Override
    public List<RPermission> queryRPermissionList(HashMap<String, Object> paramSet) throws Exception {
        return rolePermissionMapper.queryRPermissionList(paramSet);
    }

    @Override
    public int deleteByRolePermissionId(String rolePermissionId) throws Exception {
        return rolePermissionMapper.deleteByRolePermissionId(rolePermissionId);
    }

    @Override
    public int deleteByRoleId(String roleId) throws Exception {
        return rolePermissionMapper.deleteByRoleId(roleId);
    }

    @Override
    public RolePermission queryRolePermissionById(String roleId) throws Exception {
        return rolePermissionMapper.queryRolePermissionById(roleId);
    }

    @Override
    public List<RPermission> queryRolePermissionListByRoleId(String roleId) throws Exception {
        return rolePermissionMapper.queryRolePermissionListByRoleId(roleId);
    }

    @Override
    public int changeDoPermissionByRolePermissionId(RolePermission rolePermission) throws Exception {
        RolePermission newRolePermission = new RolePermission();
        newRolePermission = rolePermissionMapper.queryRolePermissionById(rolePermission.getId());
        newRolePermission.setDoPermission(rolePermission.getDoPermission());
        return rolePermissionMapper.changeDoPermissionByRolePermissionId(newRolePermission);
    }
}
