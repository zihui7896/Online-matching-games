package com.kob.almatchingsystem;

import com.kob.almatchingsystem.service.impl.AlMatchingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlMatchingSystemApplication {
    public static void main (String[] args) {
        AlMatchingServiceImpl.matchingPool.start(); // 启动匹配线程
        SpringApplication.run(AlMatchingSystemApplication.class, args);
    }
}
