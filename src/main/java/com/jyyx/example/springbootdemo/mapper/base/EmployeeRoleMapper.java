package com.jyyx.example.springbootdemo.mapper.base;

import com.jyyx.example.springbootdemo.entity.base.ERole;
import com.jyyx.example.springbootdemo.entity.base.EmployeeRole;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface EmployeeRoleMapper extends MyMapper<EmployeeRole> {
    List<EmployeeRole> queryRoleListByEmployeeId(String employeeId);
    List<ERole> queryEmployeeRoleList(HashMap<String,Object> paramSet);
    int deleteByEmployeeRoleId(String employeeRoleId);
    int deleteByEmployeeId(String employeeId);
    EmployeeRole queryEmployeeRoleById(String employeeRoleId);
    List<ERole> queryEmployeeRoleListByEmployeeId(String employeeId);
}
