package com.wushen.cmsservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 @descriptions
 @author wushen
 @create 2020-07-23 14:51
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wushen"})
@MapperScan("com.wushen.cmsservice.mapper")
public class CmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class,args);
    }
}
