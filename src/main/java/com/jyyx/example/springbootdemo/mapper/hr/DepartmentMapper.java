package com.jyyx.example.springbootdemo.mapper.hr;

import com.jyyx.example.springbootdemo.entity.hr.Department;
import com.jyyx.example.springbootdemo.entity.hr.Store;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface DepartmentMapper extends MyMapper<Department> {
    Department queryDepartmentById(String departmentId);
    List<Department> queryDepartmentList(HashMap<String,Object> paramSet);
    int deleteById(String departmentId);
}
