package com.jyyx.example.springbootdemo.entity.weixin.resp;

/**
 * 文本消息
 */

public class RespTextMessage extends RespMessage{
    //回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
