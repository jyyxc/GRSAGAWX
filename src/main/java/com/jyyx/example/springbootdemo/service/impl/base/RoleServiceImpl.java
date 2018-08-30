package com.jyyx.example.springbootdemo.service.impl.base;

import com.jyyx.example.springbootdemo.entity.base.Role;
import com.jyyx.example.springbootdemo.mapper.base.RoleMapper;
import com.jyyx.example.springbootdemo.service.base.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public int addOrEditRole(Role role) throws Exception {
        if(role.getId() != null && !"".equals(role.getId())){
            //修改
            Role newrole = roleMapper.queryRoleById(role.getId());
            newrole.setRoleName(role.getRoleName());
            newrole.setEditDate(new Date());
            return roleMapper.updateByPrimaryKey(newrole);
        }else{
            //新增
            role.setCreateDate(new Date());
            role.setIsDeleted(0);
            return roleMapper.insert(role);
        }
    }

    @Override
    public Role queryRoleById(String roleId) throws Exception {
        return roleMapper.queryRoleById(roleId);
    }

    @Override
    public List<Role> queryRoleList(HashMap<String, Object> paramSet) throws Exception {
        return roleMapper.queryRoleList(paramSet);
    }

    @Override
    public int deleteById(String roleId) throws Exception {
        return roleMapper.deleteById(roleId);
    }
}
