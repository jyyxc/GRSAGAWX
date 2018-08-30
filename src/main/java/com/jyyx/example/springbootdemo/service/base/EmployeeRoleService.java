package com.jyyx.example.springbootdemo.service.base;

import com.jyyx.example.springbootdemo.entity.base.ERole;
import com.jyyx.example.springbootdemo.entity.base.EmployeeRole;

import java.util.HashMap;
import java.util.List;

public interface EmployeeRoleService {
    int addOrEditEmployeeRole(EmployeeRole employeeRole)throws Exception;
    List<EmployeeRole> queryRoleListByEmployeeId(String  employeeId)throws Exception;
    List<ERole> queryEmployeeRoleList(HashMap<String,Object> paramSet)throws Exception;
    int deleteByEmployeeRoleId(String employeeRoleId)throws Exception;
    int deleteByEmployeeId(String employeeId)throws Exception;
    EmployeeRole queryEmployeeRoleById(String employeeRoleId)throws Exception;
    List<ERole> queryEmployeeRoleListByEmployeeId(String employeeId)throws Exception;
}
