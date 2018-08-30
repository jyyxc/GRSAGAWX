package com.jyyx.example.springbootdemo.entity.weixin.startup;

import com.jyyx.example.springbootdemo.entity.weixin.Thread.TokenThread;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 启动类 项目启动时运行线程
 * @author jyyx
 */

@Component
public class MyStartUp implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        new Thread(new TokenThread()).start();
    }
}
