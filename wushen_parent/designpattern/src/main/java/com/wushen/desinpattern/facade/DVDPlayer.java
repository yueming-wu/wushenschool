package com.wushen.desinpattern.facade;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 11:18
 */
public class DVDPlayer {
    /*饿汉式静态常量*/
    private static final DVDPlayer instance = new DVDPlayer();
    private DVDPlayer(){}
    public static DVDPlayer getInstance(){
        return instance;
    }
    public void on(){
        System.out.println("DVD on");
    }
    public void off(){
        System.out.println("DVD off");
    }
    public void play(){
        System.out.println("DVD is playing");
    }
    public void pause(){
        System.out.println("DVD is paused");
    }
    /*其他方法*/
}
