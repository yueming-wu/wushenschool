package com.wushen.canalservice;

import com.wushen.canalservice.client.CanalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 @descriptions
 @author wushen
 @create 2020-08-06 19:24
 */
@SpringBootApplication
public class CanalApplication implements CommandLineRunner {
    @Autowired
    private CanalClient canalClient;
    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        canalClient.run();
    }
}
