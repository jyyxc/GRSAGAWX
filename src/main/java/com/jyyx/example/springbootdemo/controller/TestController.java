package com.jyyx.example.springbootdemo.controller;

import com.jyyx.example.springbootdemo.entity.test.CbtTestConfig;
import com.jyyx.example.springbootdemo.entity.test.TestTran;
import com.jyyx.example.springbootdemo.entity.weixin.base.WxUser;
import com.jyyx.example.springbootdemo.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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


    @RequestMapping(value="testTran")
    @ResponseBody
    @Transactional
    public void testTran(){
        for(int i = 0; i < 5 ; i++){
            TestTran testTran = new TestTran();
            if(i !=3) {
                testTran.setName("aaa");
            }else{
                testTran.setName("bbbbbbbb");
            }
            testService.insert(testTran);
            System.out.println(testTran.getId());
        }
    }
}

