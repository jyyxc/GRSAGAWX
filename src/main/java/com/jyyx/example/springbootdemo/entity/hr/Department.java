package com.jyyx.example.springbootdemo.entity.hr;

import com.jyyx.example.springbootdemo.entity.base.BaseObject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="hr_department")
public class Department extends BaseObject {

    @Column
    String departmentName;


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
