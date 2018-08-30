package com.jyyx.example.springbootdemo.controller.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Controller
@RequestMapping(value="article")
public class ArticleController {
    @RequestMapping(value="/goBrand")
    public String test(HashMap<String,String> map)
    {
        return "weixin/brand";
    }
}
