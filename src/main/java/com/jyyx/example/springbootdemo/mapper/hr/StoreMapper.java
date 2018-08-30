package com.jyyx.example.springbootdemo.mapper.hr;

import com.jyyx.example.springbootdemo.entity.hr.Store;
import com.jyyx.example.springbootdemo.util.MyMapper;

import java.util.HashMap;
import java.util.List;

public interface StoreMapper extends MyMapper<Store> {

    Store queryStoreById(String storeId);
    List<Store> queryStoreList(HashMap<String,Object> paramSet);
    int deleteById(String storeId);
}
