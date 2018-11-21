package com.jyyx.example.springbootdemo.mapper.test;

import com.jyyx.example.springbootdemo.entity.test.CbtTestConfig;
import org.apache.ibatis.annotations.Mapper;

public interface CbtTestConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CbtTestConfig record);

    int insertSelective(CbtTestConfig record);

    CbtTestConfig selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CbtTestConfig record);

    int updateByPrimaryKey(CbtTestConfig record);
}