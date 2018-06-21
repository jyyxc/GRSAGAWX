package com.jyyx.example.springbootdemo.util;

import org.slf4j.LoggerFactory;
import  org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 * @author jyyx
 * @date 2018.6.4
 */

@Component
public class CorsFilterUtil implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(CorsFilterUtil.class);

    public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain)throws IOException,ServletException {
        HttpServletResponse response = (HttpServletResponse)res;
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Contro-Allow-Methods","POST,GET,OPTIONS,DELETE,PUT,OPTIONS,PATCH");
        response.setHeader("Access-Control-Max-Age","3600");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Content-type,Accept,Origin,LastModified");
        System.out.println("***************************过滤器被使用****************************");
        chain.doFilter(req,res);
    }

    public void init(FilterConfig filterConfig){}
    public void destroy(){}
}
