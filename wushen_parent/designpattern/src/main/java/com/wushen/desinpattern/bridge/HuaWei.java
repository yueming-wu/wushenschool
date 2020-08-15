package com.wushen.desinpattern.bridge;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 20:15
 */
public class HuaWei implements Brand{
    @Override
    public void open() {
        System.out.println("华为手机打开");
    }

    @Override
    public void close() {
        System.out.println("华为手机关闭");
    }

    @Override
    public void call() {
        System.out.println("华为手机打电话");
    }
}
