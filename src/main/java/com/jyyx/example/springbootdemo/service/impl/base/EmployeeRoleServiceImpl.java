package com.jyyx.example.springbootdemo.service.impl.base;

import com.jyyx.example.springbootdemo.entity.base.ERole;
import com.jyyx.example.springbootdemo.entity.base.EmployeeRole;
import com.jyyx.example.springbootdemo.mapper.base.EmployeeRoleMapper;
import com.jyyx.example.springbootdemo.service.base.EmployeeRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeRoleServiceImpl implements EmployeeRoleService {

    @Autowired
    private EmployeeRoleMapper employeeRoleMapper;

    @Override
    public int addOrEditEmployeeRole(EmployeeRole employeeRole) throws Exception {
        employeeRole.setCreateDate(new Date());
        employeeRole.setIsDeleted(0);
        return employeeRoleMapper.insert(employeeRole);

    }

    @Override
    public List<EmployeeRole> queryRoleListByEmployeeId(String employeeId) {
        return employeeRoleMapper.queryRoleListByEmployeeId(employeeId);
    }

    @Override
    public List<ERole> queryEmployeeRoleList(HashMap<String,Object> paramSet) throws Exception {
        return employeeRoleMapper.queryEmployeeRoleList(paramSet);
    }

    @Override
    public int deleteByEmployeeRoleId(String employeeRoleId) throws Exception {
        return employeeRoleMapper.deleteByEmployeeRoleId(employeeRoleId);
    }

    @Override
    public int deleteByEmployeeId(String employeeId) throws Exception {
        return employeeRoleMapper.deleteByEmployeeId(employeeId);
    }

    @Override
    public EmployeeRole queryEmployeeRoleById(String employeeRoleId) throws Exception {
        return employeeRoleMapper.queryEmployeeRoleById(employeeRoleId);
    }

    @Override
    public List<ERole> queryEmployeeRoleListByEmployeeId(String employeeId) throws Exception {
        return employeeRoleMapper.queryEmployeeRoleListByEmployeeId(employeeId);
    }
}
