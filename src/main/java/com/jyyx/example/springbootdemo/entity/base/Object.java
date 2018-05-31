package com.jyyx.example.springbootdemo.entity.base;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Object {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;  //表主键id
    @Column(name = "CREATEUSER")
    String createUser;  //创建数据的用户id
    @Column(name = "CREATEDATE")
    Date createDate;    //创建日期
    @Column(name = "EDITUSER")
    String editUser;    //修改数据的用户id
    @Column(name = "EDITDATE")
    Date editDate;  //修改时间
    @Column(name = "ISDELETED")
    String isDeleted;   //删除状态 0未删 1已删

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getEditUser() {
        return editUser;
    }

    public void setEditUser(String editUser) {
        this.editUser = editUser;
    }

    public Date getEditDate() {
        return editDate;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", editUser='" + editUser + '\'' +
                ", editDate=" + editDate +
                ", isDeleted='" + isDeleted + '\'' +
                '}';
    }
}
