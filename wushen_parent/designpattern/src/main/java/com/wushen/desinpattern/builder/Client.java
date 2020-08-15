package com.wushen.desinpattern.builder;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:16
 */
public class Client {
    public static void main(String[] args) {
        CommonHouse commonHouse = new CommonHouse();
        commonHouse.build();
    }
}
