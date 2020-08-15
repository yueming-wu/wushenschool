package com.wushen.desinpattern.observer;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 18:00
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditions currentConditions = new CurrentConditions();
        BaiduObserver baiduObserver = new BaiduObserver();
        weatherData.registerObserver(currentConditions);
        weatherData.registerObserver(baiduObserver);
        System.out.println("通知所有的观察者查看信息更新");
        weatherData.setData(10f,100f,50f);
        System.out.println("取消气象站的观察者");
        weatherData.removeObserver(currentConditions);
        weatherData.setData(10f,100f,50f);
    }
}
