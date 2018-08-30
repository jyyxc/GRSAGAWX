package com.jyyx.example.springbootdemo.entity.weixin.util;

import com.jyyx.example.springbootdemo.entity.weixin.base.AccessToken;
import com.jyyx.example.springbootdemo.entity.weixin.menu.WeixinMenu;
import com.jyyx.example.springbootdemo.entity.weixin.template.WxTemplate;
import jdk.nashorn.internal.parser.Token;
import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import net.sf.json.JSONObject;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

/**
 * 微信公众平台通用接口工具类
 * @author jyyx
 * @date 2018.6.4
 */

public class WeixinUtil {
    //获取access_token的接口地址(GET)限200(次/天)
    public final  static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    // 菜单创建（POST） 限100（次/天）
    public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    //发送模板消息接口地址(POST)
    public static String send_model_msg_url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";

    //获取用户基本信息(GET)
    public static String get_user_info = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";

    // 临时二维码
    public static String QR_SCENE = "QR_SCENE";
    // 永久二维码
    public static String QR_LIMIT_SCENE = "QR_LIMIT_SCENE";
    // 永久二维码(字符串)
    public static String QR_LIMIT_STR_SCENE = "QR_LIMIT_STR_SCENE";
    // 创建二维码
    public static String create_ticket_path = "https://api.weixin.qq.com/cgi-bin/qrcode/create";
    // 通过ticket换取二维码
    public static String showqrcode_path = "https://mp.weixin.qq.com/cgi-bin/showqrcode";

    private static Logger log = LoggerFactory.getLogger(WeixinUtil.class);

    /**
     *发起https请求并获取结果
     * @param requestUrl 请求地址
     * @param requestMethod 请求方式(GET、POST)
     * @param outputStr 提交的数据
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject httpRequest(String requestUrl,String requestMethod,String outputStr){
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try{
            //创建SSLContext对象，并使用我们制定的信任管理器初始化
            TrustManager[] tm = {new MyX509TrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL","SunJSSE");
            sslContext.init(null,tm,new java.security.SecureRandom());
            //从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            URL url = new URL(requestUrl);
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(ssf);

            httpsURLConnection.setDoOutput(true);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setUseCaches(false);
            //设置请求方式(POST/GET)
            httpsURLConnection.setRequestMethod(requestMethod);

            if("GET".equalsIgnoreCase(requestMethod))
                httpsURLConnection.connect();

            //当有数据需要提交时
            if(null != outputStr){
                OutputStream outputStream = httpsURLConnection.getOutputStream();
                //注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            //讲返回的输入流转换成字符串
            InputStream inputStream = httpsURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null){
                buffer.append(str);
            }
            bufferedReader.close();;
            inputStreamReader.close();;
            //释放资源
            inputStream.close();
            inputStream = null;
            httpsURLConnection.disconnect();;
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (ConnectException ce){
            log.error("Weixin server connection timed out");
        }catch (Exception e){
            log.error("https request error:{}",e);
        }
        return  jsonObject;
    }

    /**
     * 获取access_token
     * @param appid 凭证
     * @param appsecret 秘钥
     */
    public static AccessToken getAccessToken(String appid,String appsecret){
        AccessToken accessToken = null;
        String requestUrl = access_token_url.replace("APPID",appid).replace("APPSECRET",appsecret);
        JSONObject jsonObject = httpRequest(requestUrl,"GET",null);
        //如果请求成功
        if(null != jsonObject){
            try{
                accessToken = new AccessToken();
                accessToken.setToken(jsonObject.getString("access_token"));
                accessToken.setExpiresIn(jsonObject.getInt("expires_in"));
            }catch (Exception e){
                log.error("获取token失败");
            }
        }
        return  accessToken;
    }

    /**
     * 创建菜单
     * @param menu 菜单实例
     * @return 0成功 其他失败
     */
    public static int createMenu(WeixinMenu menu){
        int result = 0;
        //拼装创建菜单url
        String requestUrl =  menu_create_url.replace("ACCESS_TOKEN",TokenUtil.accessToken.getToken());
        //将菜单对象转换成json字符串
        String jsonMenu = JSONObject.fromObject(menu).toString();
        //调用接口创建菜单
        JSONObject jsonObject = httpRequest(requestUrl,"POST",jsonMenu);
        if(null != jsonObject){
            if(0 != jsonObject.getInt("errcode")){
                result = jsonObject.getInt("errcode");
               System.out.println("创建菜单失败 errcode:{"+jsonObject.getInt("errcode")+"} errmsg:{"+jsonObject.getString("errmsg")+"}");
            }
        }
        return  result;
    }

    /**
     * 发送模板消息
     * @param wxTemplate
     */

    public static String sendModelMsg(WxTemplate wxTemplate){
        //替换地址中的accessToken参数
        String requestUrl = send_model_msg_url.replace("ACCESS_TOKEN",TokenUtil.accessToken.getToken());
        //把wxTemplate对象转为json字符串
        String templateJson = JSONObject.fromObject(wxTemplate).toString();
        JSONObject jsonObject = httpRequest(requestUrl,"POST",templateJson);
        return  jsonObject.toString();
    }

}

