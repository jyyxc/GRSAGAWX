package com.jyyx.example.springbootdemo.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * Created by jyyx on 2018/6/1
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
