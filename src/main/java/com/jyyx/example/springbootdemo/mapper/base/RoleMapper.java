package com.jyyx.example.springbootdemo.mapper.base;


import com.jyyx.example.springbootdemo.entity.base.Role;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface RoleMapper extends MyMapper<Role> {

    Role queryRoleById(String roleId);
    List<Role> queryRoleList(HashMap<String,Object> paramSet);
    int deleteById(String RoleId);

}
