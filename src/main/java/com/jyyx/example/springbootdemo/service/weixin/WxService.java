package com.jyyx.example.springbootdemo.service.weixin;

import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;

import java.util.HashMap;

public interface WxService {
    WxUser queryWxUserByOpenId(String openId)throws Exception;
    WxUser queryWxUserByParamSet(HashMap<String,String> paramSet)throws Exception;
    int saveBind(WxUser wxUser)throws Exception;
}
