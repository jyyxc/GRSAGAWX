package com.jyyx.example.springbootdemo.service.impl.hr;

import com.jyyx.example.springbootdemo.entity.hr.Employee;
import com.jyyx.example.springbootdemo.mapper.hr.EmployeeMapper;
import com.jyyx.example.springbootdemo.service.hr.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> queryEmployeeList(HashMap<String,Object> paramSet) throws Exception {
        return  employeeMapper.queryEmployeeList(paramSet);
    }

    @Override
    public Employee queryEmployeeById(String employeeId) throws Exception {
        return employeeMapper.queryEmployeeById(employeeId);
    }

    @Override
    public int addOrEditEmployee(Employee employee) throws Exception {
        int result ;
        //如果id不等于空说明是修改
        if(!"".equals(employee.getId()) && employee.getId ()!= null ){
            Employee newEmp = employeeMapper.queryEmployeeById(employee.getId());
            newEmp.setEmployeeName(employee.getEmployeeName());
            newEmp.setAge(employee.getAge());
            newEmp.setIdCard(employee.getIdCard());
            newEmp.setTelephone(employee.getTelephone());
            newEmp.setPosition(employee.getPosition());
            newEmp.setSex(employee.getSex());
            newEmp.setDepartmentId(employee.getDepartmentId());
            newEmp.setDepartmentName(employee.getDepartmentName());
            newEmp.setStoreId(employee.getStoreId());
            newEmp.setEditDate(new Date());
            result = employeeMapper.updateByPrimaryKey(newEmp);
        }else{
            //新增
            employee.setIsDeleted(0);
            //审批状态默认为2  审批中
            employee.setStatus(2);
            employee.setCreateDate(new Date());
            result =  employeeMapper.insert(employee);
        }
        return result;
    }

    @Override
    public int deleteByEmployeeId(String employeeId) throws Exception {
        return employeeMapper.deleteByEmployeeId(employeeId);
    }

    @Override
    public int changeStatus(Employee employee) throws Exception {
        int result;
        Employee newEmp = employeeMapper.queryEmployeeById(employee.getId());
        newEmp.setStatus(employee.getStatus());
        result = employeeMapper.updateByPrimaryKey(newEmp);
        return result;
    }

    @Override
    public Employee queryEmployeeByBindParam(HashMap<String,String> paramSet) throws Exception {
        return employeeMapper.queryEmployeeByBindParam(paramSet);
    }
}
