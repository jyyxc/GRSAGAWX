package com.jyyx.example.springbootdemo.service.impl.hr;

import com.jyyx.example.springbootdemo.entity.hr.Department;
import com.jyyx.example.springbootdemo.mapper.hr.DepartmentMapper;
import com.jyyx.example.springbootdemo.service.hr.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public int addOrEditDepartment(Department department) throws Exception {
        if(department.getId() != null && !"".equals(department.getId())){
            //说明是修改
            Department newd = departmentMapper.queryDepartmentById(department.getId());
            newd.setDepartmentName(department.getDepartmentName());
            newd.setEditDate(new Date());
            return departmentMapper.updateByPrimaryKey(newd);
        }else {
            department.setIsDeleted(0);
            department.setCreateDate(new Date());
            return departmentMapper.insert(department);
        }
    }

    @Override
    public Department queryDepartmentById(String departmentId) throws Exception {
        Department department = departmentMapper.queryDepartmentById(departmentId);
        return department;
    }

    @Override
    public List<Department> queryDepartmentList(HashMap<String,Object> paramSet) throws Exception {
        List<Department> departmentList = departmentMapper.queryDepartmentList(paramSet);
        return departmentList;
    }

    @Override
    public int deleteById(String departmentId) throws Exception {
        return departmentMapper.deleteById(departmentId);
    }
}
