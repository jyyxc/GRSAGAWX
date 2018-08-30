package com.jyyx.example.springbootdemo.entity.base;

/**
 * 临时结果集 role+permssion字段
 */
public class RPermission {
    String id;
    String permissionName;
    String roleName;
    String uri;
    String roleId;
    String permissionId;
    int doPermission;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public int getDoPermission() {
        return doPermission;
    }

    public void setDoPermission(int doPermission) {
        this.doPermission = doPermission;
    }

    public RPermission() {

    }
}
