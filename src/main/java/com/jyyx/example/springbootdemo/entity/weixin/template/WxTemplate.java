package com.jyyx.example.springbootdemo.entity.weixin.template;

import java.util.Map;

public class WxTemplate {
    //模板消息id
    private String template_id;
    //用户openId
    private String toUser;
    //URL置空，则在发送后，点击模板消息会进入一个空白页面(ios)，或无法点击(android)
    private String url;

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopColor() {
        return topColor;
    }

    public void setTopColor(String topColor) {
        this.topColor = topColor;
    }

    public Map<String, TemplateData> getData() {
        return data;
    }

    public void setData(Map<String, TemplateData> data) {
        this.data = data;
    }

    //标题颜色
    private String topColor;
    //详细内容
    private Map<String,TemplateData> data;

}
