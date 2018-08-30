package com.jyyx.example.springbootdemo.service.hr;

import com.jyyx.example.springbootdemo.entity.hr.Store;

import java.util.HashMap;
import java.util.List;

public interface StoreService {
    int addOrEditStore(Store store)throws Exception;
    Store queryStoreById(String storeId)throws Exception;
    List<Store> queryStoreList(HashMap<String,Object> paramSet)throws Exception;
    int deleteById(String storeId)throws Exception;
}
