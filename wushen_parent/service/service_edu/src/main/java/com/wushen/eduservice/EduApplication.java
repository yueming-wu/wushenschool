package com.wushen.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 @descriptions
 @author wushen
 @create 2020-07-30 7:12
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wushen"})
@EnableDiscoveryClient //向Nacos当中注册,相对于Nacos来说,所有注册端都是客户端
@EnableFeignClients //调用端启动服务调用
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
