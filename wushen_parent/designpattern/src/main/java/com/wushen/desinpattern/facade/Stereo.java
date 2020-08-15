package com.wushen.desinpattern.facade;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 11:48
 */
public enum  Stereo {
    /*枚举常量*/
    INSTANCE;
    public void on(){
        System.out.println("Stereo on");
    }
    public void off(){
        System.out.println("Stereo off");
    }
    public void up(){
        System.out.println("Stereo up");
    }
    public void down(){
        System.out.println("Stereo down");
    }
}

