package com.jyyx.example.springbootdemo.entity.weixin.menu;

/**
 * View类型按钮
 */
public class ViewButton extends Button {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String type;
    private String url;
}
