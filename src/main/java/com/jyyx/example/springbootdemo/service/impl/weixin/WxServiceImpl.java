package com.jyyx.example.springbootdemo.service.impl.weixin;

import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.mapper.weixin.WxMapper;
import com.jyyx.example.springbootdemo.service.weixin.WxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;

@Service
public class WxServiceImpl implements WxService {

    @Autowired
    private WxMapper wxMapper;

    @Override
    public WxUser queryWxUserByOpenId(String openId) throws Exception {
        return wxMapper.queryWxUserByOpenId(openId);
    }

    @Override
    public WxUser queryWxUserByParamSet(HashMap<String,String> paramSet) throws Exception {
        return wxMapper.queryWxUserByParamSet(paramSet);
    }

    @Override
    public int saveBind(WxUser wxUser) throws Exception {
        wxUser.setIsDeleted(0);
        wxUser.setCreateDate(new Date());
        return wxMapper.insert(wxUser);
    }
}
