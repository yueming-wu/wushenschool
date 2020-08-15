package com.wushen.desinpattern.facade;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 11:56
 */
public class TheaterLight {
    private TheaterLight(){}
    private static class InnerTheaterLight{
        private static final TheaterLight THEATER_LIGHT = new TheaterLight();
    }
    public static synchronized TheaterLight getInstance(){
        return InnerTheaterLight.THEATER_LIGHT;
    }
    public void bright(){
        System.out.println("TheaterLight is brighter");
    }
    public void dim(){
        System.out.println("TheaterLight is dim");
    }
}
