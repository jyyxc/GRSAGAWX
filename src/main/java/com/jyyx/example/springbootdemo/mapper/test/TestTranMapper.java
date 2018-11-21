package com.jyyx.example.springbootdemo.mapper.test;

import com.jyyx.example.springbootdemo.entity.test.TestTran;

public interface TestTranMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTran record);

    int insertSelective(TestTran record);

    TestTran selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTran record);

    int updateByPrimaryKey(TestTran record);
}