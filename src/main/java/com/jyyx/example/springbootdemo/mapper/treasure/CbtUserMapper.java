package com.jyyx.example.springbootdemo.mapper.treasure;

import com.jyyx.example.springbootdemo.entity.treasure.CbtUser;

public interface CbtUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CbtUser record);

    int insertSelective(CbtUser record);

    CbtUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CbtUser record);

    int updateByPrimaryKeyWithBLOBs(CbtUser record);

    int updateByPrimaryKey(CbtUser record);
}