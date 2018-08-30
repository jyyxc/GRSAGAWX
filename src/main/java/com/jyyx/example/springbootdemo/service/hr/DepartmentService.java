package com.jyyx.example.springbootdemo.service.hr;

import com.jyyx.example.springbootdemo.entity.hr.Department;

import java.util.HashMap;
import java.util.List;

public interface DepartmentService {
    int addOrEditDepartment(Department department)throws Exception;
    Department queryDepartmentById(String departmentId)throws Exception;
    List<Department> queryDepartmentList(HashMap<String,Object> paramSet)throws Exception;
    int deleteById(String departmentId)throws Exception;
}
