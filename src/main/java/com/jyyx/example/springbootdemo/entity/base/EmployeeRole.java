package com.jyyx.example.springbootdemo.entity.base;

import com.jyyx.example.springbootdemo.entity.base.BaseObject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="sys_employee_role")
public class EmployeeRole extends BaseObject {
    @Column(name="employeeid")
    String  employeeId;

    @Column(name="roleid")
    String  roleId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
