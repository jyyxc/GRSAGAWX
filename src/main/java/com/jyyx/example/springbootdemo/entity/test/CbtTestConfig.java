package com.jyyx.example.springbootdemo.entity.test;

import java.io.Serializable;

public class CbtTestConfig implements Serializable {
    private Integer id;

    private Integer sleeptime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSleeptime() {
        return sleeptime;
    }

    public void setSleeptime(Integer sleeptime) {
        this.sleeptime = sleeptime;
    }
}