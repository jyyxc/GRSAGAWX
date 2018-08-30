package com.jyyx.example.springbootdemo.controller;

import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.service.weixin.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value="Test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value="/test")
    public String test(HashMap<String,String> map,
    @RequestParam(value ="text")String text)
    {
        WxUser wxUser = new WxUser();
        wxUser.setName("测试");
        wxUser.setTelephone("13082944530");
        wxUser.setOpenId("123456");
        wxUser.setIdCard("220211199407310011");
//        testMapper.insert(wxUser);
        map.put("sayHi","欢迎使用spring-boot");
        map.put("sayHello",text);
        return "test";
    }


    @RequestMapping(value="/testQuery")
    @ResponseBody
    public String testQuery() throws Exception {
        List<WxUser> userList = testService.queryAll();
        String str = "";
        for(WxUser w : userList){
            str += w.toString() + ",";
        }
        str = str.substring(0,str.length() - 1);
        return str;
    }

    @RequestMapping(value="/getCount")
    @ResponseBody
    public int getCount() throws Exception {
        int i  = testService.getCount();
        return i;
    }
}

