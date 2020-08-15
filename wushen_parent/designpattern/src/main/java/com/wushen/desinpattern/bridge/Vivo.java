package com.wushen.desinpattern.bridge;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 20:16
 */
public class Vivo implements Brand {
    @Override
    public void open() {
        System.out.println("vivo手机打开");
    }

    @Override
    public void close() {
        System.out.println("vivo手机关闭");
    }

    @Override
    public void call() {
        System.out.println("vivo手机打电话");
    }
}
