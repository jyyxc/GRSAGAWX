package com.jyyx.example.springbootdemo.service;

import com.jyyx.example.springbootdemo.entity.base.Permission;

import java.util.HashMap;
import java.util.List;

public interface BasePermissionService {
    HashMap<String,Object> queryPermissionByOpenId(String openId, String uri)throws Exception;
}
