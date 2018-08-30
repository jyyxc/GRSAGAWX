package com.jyyx.example.springbootdemo.mapper.weixin;

import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;

public interface WxMapper extends MyMapper<WxUser> {
    WxUser queryWxUserByOpenId(String openId);
    WxUser queryWxUserByParamSet(HashMap<String,String> paramSet);
    int saveBind(WxUser wxUser);
}
