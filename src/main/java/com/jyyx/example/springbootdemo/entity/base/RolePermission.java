package com.jyyx.example.springbootdemo.entity.base;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="sys_role_permission")
public class RolePermission extends BaseObject {
    @Column(name = "roleid")
    String roleId;

    @Column(name = "permissionid")
    String permissionId;
    //操作权限(0有权限 1没有)
    @Column(name = "dopermission")
    int doPermission;


    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public int getDoPermission() {
        return doPermission;
    }

    public void setDoPermission(int doPermission) {
        this.doPermission = doPermission;
    }


}



