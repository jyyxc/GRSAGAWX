package com.jyyx.example.springbootdemo.entity.weixin.req;

/**
 * 文本消息
 */

public class ReqTextMessage extends ReqMessage{
    //消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
