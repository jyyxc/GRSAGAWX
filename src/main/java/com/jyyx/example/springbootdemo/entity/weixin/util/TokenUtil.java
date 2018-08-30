package com.jyyx.example.springbootdemo.entity.weixin.util;

import com.jyyx.example.springbootdemo.entity.weixin.base.AccessToken;
import org.springframework.stereotype.Component;

/**
 * 配置微信公众号appid和appsecret
 * @author jyyx
 */


@Component
public class TokenUtil {
    //第三方用户唯一凭证
    public static String appid = "wx249e933ff4fe1b5b";
    //第三方用户唯一凭证秘钥
    public static String appsecret = "22c3cab210b6834f6acc9ee0d1eebcbc";
    public static AccessToken accessToken  = null;

}
