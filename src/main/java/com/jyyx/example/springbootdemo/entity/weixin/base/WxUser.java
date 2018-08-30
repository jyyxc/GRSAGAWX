package com.jyyx.example.springbootdemo.entity.weixin.base;

import com.jyyx.example.springbootdemo.entity.base.BaseObject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="wx_user")
public class WxUser extends BaseObject {

    @Column(name="telephone")
    private String telephone;

    @Column(name="name")
    private String name;

    @Column(name="idcard")
    private String idCard;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    @Column(name="employeeid")
    private String employeeId;

    @Column(name="openid")
    private String openId;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }




}
