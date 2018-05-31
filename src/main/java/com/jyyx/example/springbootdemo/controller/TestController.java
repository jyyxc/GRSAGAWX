package com.jyyx.example.springbootdemo.controller;

import com.jyyx.example.springbootdemo.entity.base.Object;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value="/test")
    public String test(){
        return "hello world";
    }
}
