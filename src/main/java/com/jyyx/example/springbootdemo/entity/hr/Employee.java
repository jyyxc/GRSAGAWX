package com.jyyx.example.springbootdemo.entity.hr;

import com.jyyx.example.springbootdemo.entity.base.BaseObject;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

@Table(name="hr_employee")
public class Employee extends BaseObject {

    //员工编号
    @Column(name="employeeno")
    String employeeNo;

    //员工姓名
    @Column(name="employeename")
    String employeeName;

    //性别
    @Column(name="sex")
    int sex;

    //年龄
    @Column(name="age")
    int age;

    //身份证号
    @Column(name="idcard")
    String idCard;

    //员工类型(0总部员工 1门店员工)
    @Column(name="employeetype")
    int employeeType;

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    //部门id
    @Column(name="departmentid")

    int departmentId;

    //部门名称
    @Column(name="departmentname")
    String departmentName;

    //职位
    @Column(name="position")
    String position;

    @Column(name="birthday")
    Date birthday;

    @Column(name="telephone")
    String telephone;

    //在职状态(0在职 1离职 2审批)
    @Column(name="status")
    int status;

    //所在门店id(可选总部员工为空)
    @Column(name="storeid")
    String storeId;

    //所在门店名称可选总部员工为空)
    @Column(name="storename")
    String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
