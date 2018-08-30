package com.jyyx.example.springbootdemo.entity.weixin.Thread;


import com.jyyx.example.springbootdemo.entity.weixin.util.TokenUtil;
import com.jyyx.example.springbootdemo.entity.weixin.util.WeixinUtil;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;



/**
 * 定时获取微信access_token线程
 * @author  jyyx
 */
public class TokenThread  implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(TokenThread.class);
    @Override
    public void run() {
        boolean trigger = true;
        TokenUtil.accessToken = WeixinUtil.getAccessToken(TokenUtil.appid,TokenUtil.appsecret);
        while (trigger){
            trigger = false;
            try{
                if(null != TokenUtil.accessToken){
                    logger.info("获取access_token成功，有效时长:{}秒 token:{}",TokenUtil.accessToken.getExpiresIn(),TokenUtil.accessToken.getToken());
//                    System.out.println("获取access_token成功，有效时长:"+TokenUtil.accessToken.getExpiresIn()+"秒,token:"+TokenUtil.accessToken.getToken());
                    //休眠  有效期过了之后再次获取
                    Thread.sleep((TokenUtil.accessToken.getExpiresIn() - 200) * 1000) ;
                    trigger = true;
                }else{
                    //如果access获取失败,60秒之后再获取
                    logger.info("获取access_token失败");
                    Thread.sleep(60 * 1000);
                    trigger = true;
                }
            }catch (InterruptedException e){
                try {
                    Thread.sleep(60 * 1000);
                }catch (InterruptedException e1){
//                    logger.error("{}" , e1);
                }
//                logger.error("{}",e);
            }
        }
    }


}
