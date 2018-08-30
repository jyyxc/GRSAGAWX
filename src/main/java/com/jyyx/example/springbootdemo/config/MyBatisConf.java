package com.jyyx.example.springbootdemo.config;


import com.github.pagehelper.PageHelper;
import com.jyyx.example.springbootdemo.SpringBootDemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/*
 * 注册MyBatis分页插件PageHelper
 */
@Configuration
public class MyBatisConf {

    private static Logger logger = LoggerFactory.getLogger(MyBatisConf.class);

    @Bean
    public PageHelper pageHelper() {
        logger.info("=========MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
