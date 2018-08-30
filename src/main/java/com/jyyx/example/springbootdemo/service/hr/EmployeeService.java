package com.jyyx.example.springbootdemo.service.hr;

import com.jyyx.example.springbootdemo.domain.Response;
import com.jyyx.example.springbootdemo.entity.hr.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService {
    List<Employee> queryEmployeeList(HashMap<String,Object> paramSet)throws Exception;
    Employee queryEmployeeById(String employeeId)throws Exception;
    int addOrEditEmployee(Employee employee)throws Exception;
    int deleteByEmployeeId(String employeeId)throws Exception;
    int changeStatus(Employee employee)throws Exception;
    Employee queryEmployeeByBindParam(HashMap<String,String> paramSet)throws Exception;
}
