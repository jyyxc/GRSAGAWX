package com.jyyx.example.springbootdemo.entity.weixin.util;
import com.jyyx.example.springbootdemo.entity.weixin.resp.Article;
import com.jyyx.example.springbootdemo.entity.weixin.resp.NewsMessage;
import com.jyyx.example.springbootdemo.entity.weixin.resp.RespTextMessage;
import sun.misc.MessageUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author jyyx
 * @date 2018.6.4
 */

public class CoreUtil {
    //定义静态变量open_id
    public static String open_id = "7";

    /**
     * 处理微信发来的请求
     */

    public static String processRequest(HttpServletRequest request, HttpServletResponse response){
        String respMessage = null;
        try{
            //默认返回的文本消息内容
            String respContent = "请求处理异常，请稍后重试!";

            //xml请求解析
            Map<String,String> requestMap = MessageUtil.parseXml(request);
            //发送方账号(open_id)
            String fromUserName = requestMap.get("FromUserName");
            //公众账号
            String toUserName = requestMap.get("ToUserName");
            //消息类型
            String msgType = requestMap.get("MsgType");
            //如接收到用户发来的消息，先把openid存到静态变量里
            open_id = fromUserName;

            //回复文本消息
            RespTextMessage textMessage = new RespTextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            //文本消息
            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
                respContent = "对不起，我不太懂您的意思。";
            } // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    List<Article> articleList = new ArrayList<Article>();
                    NewsMessage newsMessage = new NewsMessage();


                    Article article1 = new Article();
                    article1.setTitle("公众号功能介绍");
                    article1.setDescription("介绍此公众号使用教程");
                    article1.setPicUrl("http://183.131.247.94/img/test.jpg");
                    article1.setUrl("http://www.baidu.com");

                    Article article2 = new Article();
                    article2.setTitle("用户中心");
                    article2.setPicUrl("http://183.131.247.94/img/brand.jpg");
                    article2.setUrl("http://183.131.247.94/center/goCenter");

                    articleList.add(article1);
                    articleList.add(article2);

                    newsMessage.setToUserName(fromUserName);
                    newsMessage.setFromUserName(toUserName);
                    newsMessage.setCreateTime(new Date().getTime());
                    newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                    newsMessage.setFuncFlag(0);
                    newsMessage.setArticleCount(articleList.size());
                    newsMessage.setArticles(articleList);
                    respContent = MessageUtil.newsMessageToXml(newsMessage);
                    return respContent;
                }
                // 取消s订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    System.out.println("在事件里面看openid"+ open_id);
                    // TODO 自定义菜单权没有开放，暂不处理该类消息
                } else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
                    //跳转链接事件

                }
            }
            textMessage.setContent(respContent);
            respMessage = MessageUtil.textMessageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respMessage;
        }
}
