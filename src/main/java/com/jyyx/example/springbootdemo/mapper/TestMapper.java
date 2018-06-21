package com.jyyx.example.springbootdemo.mapper;

import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestMapper extends MyMapper<WxUser> {
    public List<WxUser> queryAll();
    public Integer getCount();

}
