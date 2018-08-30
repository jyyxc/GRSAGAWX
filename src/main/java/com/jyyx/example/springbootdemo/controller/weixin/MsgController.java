package com.jyyx.example.springbootdemo.controller.weixin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="msg")
public class MsgController {
    @RequestMapping(value="/sendMsg")
    public String test(HashMap<String,String> map)
    {
        return "weixin/msg";
    }
}
