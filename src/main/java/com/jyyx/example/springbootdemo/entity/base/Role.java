package com.jyyx.example.springbootdemo.entity.base;

import com.jyyx.example.springbootdemo.entity.base.BaseObject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="sys_role")
public class Role extends BaseObject {
    @Column(name="rolename")
    String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
