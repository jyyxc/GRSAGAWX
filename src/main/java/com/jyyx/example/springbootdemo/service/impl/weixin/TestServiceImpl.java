package com.jyyx.example.springbootdemo.service.impl.weixin;

import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.mapper.TestMapper;
import com.jyyx.example.springbootdemo.service.weixin.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<WxUser> queryAll()throws Exception{
        return testMapper.queryAll();
    }

    @Override
    public Integer getCount() throws Exception {
        return testMapper.getCount();
    }
}
