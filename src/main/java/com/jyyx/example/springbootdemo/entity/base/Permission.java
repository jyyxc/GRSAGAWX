package com.jyyx.example.springbootdemo.entity.base;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="sys_permission")
public class Permission extends BaseObject {
    //权限名称
    @Column(name="permissionname")
    String permissionName;

    @Column(name="uri")
    String uri;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
