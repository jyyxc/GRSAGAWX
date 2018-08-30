package com.jyyx.example.springbootdemo.service.base;



import com.jyyx.example.springbootdemo.entity.base.Role;

import java.util.HashMap;
import java.util.List;

public interface RoleService {
    int addOrEditRole(Role role)throws Exception;
    Role queryRoleById(String roleId)throws Exception;
    List<Role> queryRoleList(HashMap<String,Object> paramSet)throws Exception;
    int deleteById(String roleId)throws Exception;
}
