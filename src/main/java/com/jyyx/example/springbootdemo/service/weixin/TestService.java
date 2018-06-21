package com.jyyx.example.springbootdemo.service.weixin;


import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService {
    public List<WxUser> queryAll()throws Exception;
    public Integer getCount()throws Exception;
}
