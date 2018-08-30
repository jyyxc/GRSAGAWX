package com.jyyx.example.springbootdemo.controller.weixin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
@RequestMapping(value = "center")
public class CenterController {

    @RequestMapping(value = "goCenter")
    public String goCenter(
            HashMap<String,Object> map,
            HttpServletRequest request
    ) throws Exception {
        return "weixin/center";
    }

}
