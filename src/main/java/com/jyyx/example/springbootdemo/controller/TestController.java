package com.jyyx.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="Test")
public class TestController {
    @RequestMapping(value="/test")
    public String test(){
        return "hello world";
    }
}
