package com.jyyx.example.springbootdemo.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
@RequestMapping("error")
public class ErroController {
    @RequestMapping(value="/noPermission")
    public String test(HashMap<String,String> map)
    {
        map.put("errorMsg","您没有权限访问此页面");
        return "error";
    }

}
