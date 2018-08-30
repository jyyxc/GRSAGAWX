package com.jyyx.example.springbootdemo.service.impl.hr;

import com.jyyx.example.springbootdemo.entity.hr.Store;
import com.jyyx.example.springbootdemo.mapper.hr.StoreMapper;
import com.jyyx.example.springbootdemo.service.hr.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;

    @Override
    public int addOrEditStore(Store store) throws Exception {
        if(store.getId() != null && !"".equals(store.getId())){
            //说明是修改
            Store news =storeMapper.queryStoreById(store.getId());
            news.setStoreName(store.getStoreName());
            news.setStoreAddress(store.getStoreAddress());
            news.setStoreType(store.getStoreType());
            news.setEditDate(new Date());
            return storeMapper.updateByPrimaryKey(news);
        }else {
            store.setIsDeleted(0);
            store.setCreateDate(new Date());
            return storeMapper.insert(store);
        }
    }

    @Override
    public Store queryStoreById(String storeId) throws Exception {
        Store store = storeMapper.queryStoreById(storeId);
        return store;
    }

    @Override
    public List<Store> queryStoreList(HashMap<String,Object> paramSet) throws Exception {
        List<Store> storeList = storeMapper.queryStoreList(paramSet);
        return storeList;
    }

    @Override
    public int deleteById(String storeId) throws Exception {
        return storeMapper.deleteById(storeId);
    }

}
