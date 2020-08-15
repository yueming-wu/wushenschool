package com.wushen.desinpattern.observer;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 18:02
 */
public class BaiduObserver implements Observer {
    /*观察要观察的数据属性*/
    private float temperature;
    private float pressure;
    private float humidity;
    /*调用赋值时机*/
    @Override
    public void update(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }
    public void display(){
        System.out.println("百度网站");
        System.out.println("Baidu temperature is "+temperature+"C");
        System.out.println("Baidu pressure is "+pressure+"P");
        System.out.println("Baidu humidity is "+humidity+"C");
    }
}
