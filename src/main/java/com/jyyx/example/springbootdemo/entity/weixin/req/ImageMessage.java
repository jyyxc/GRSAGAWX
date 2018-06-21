package com.jyyx.example.springbootdemo.entity.weixin.req;

public class ImageMessage extends ReqMessage{
    //图片链接
    private  String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}


