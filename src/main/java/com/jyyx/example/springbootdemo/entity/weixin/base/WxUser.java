package com.jyyx.example.springbootdemo.entity.weixin.base;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.jyyx.example.springbootdemo.entity.base.BaseObject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="wx_user")
public class WxUser extends BaseObject {

    @Column(name="telephone")
    private String telephone;

    @Column(name="name")
    private String name;

    @Column(name="personcard")
    private String personcard;

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

    public String getPersoncard() {
        return personcard;
    }

    public void setPersoncard(String personcard) {
        this.personcard = personcard;
    }

    public String getTokenid() {
        return tokenid;
    }

    public void setTokenid(String tokenid) {
        this.tokenid = tokenid;
    }

    @Column(name="tokenid")
    private String tokenid;

}
