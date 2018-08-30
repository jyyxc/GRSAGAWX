package com.jyyx.example.springbootdemo.entity.hr;

import com.jyyx.example.springbootdemo.entity.base.BaseObject;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name="hr_store")
public class Store extends BaseObject {


    //门店名称
    @Column(name = "storename")
    String storeName;

    //门店地址
    @Column(name = "storeaddress")
    String storeAddress;

    //门店类型0加盟 1直营
    @Column(name = "storetype")
    int storeType;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public int getStoreType() {
        return storeType;
    }

    public void setStoreType(int storeType) {
        this.storeType = storeType;
    }
}
