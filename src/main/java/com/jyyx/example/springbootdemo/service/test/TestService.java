package com.jyyx.example.springbootdemo.service.test;

import com.jyyx.example.springbootdemo.entity.test.CbtTestConfig;
import com.jyyx.example.springbootdemo.entity.test.TestTran;

public interface TestService {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTran record);

    int insertSelective(TestTran record);

    TestTran selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTran record);

    int updateByPrimaryKey(TestTran record);
}
