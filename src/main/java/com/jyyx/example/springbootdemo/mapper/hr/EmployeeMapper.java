package com.jyyx.example.springbootdemo.mapper.hr;

import com.jyyx.example.springbootdemo.entity.hr.Employee;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper extends MyMapper<Employee> {
    List<Employee> queryEmployeeList(HashMap<String,Object> paramSet);
    Employee queryEmployeeById(String employeeId);
    int deleteByEmployeeId(String employeeId);
    Employee queryEmployeeByBindParam(HashMap<String,String> paramSet);
}
