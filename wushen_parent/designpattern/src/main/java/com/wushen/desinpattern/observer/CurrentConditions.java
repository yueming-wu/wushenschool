package com.wushen.desinpattern.observer;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 17:34
 */
public class CurrentConditions implements Observer {
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
        System.out.println("气象网站");
        System.out.println("Today temperature is "+temperature+"C");
        System.out.println("Today pressure is "+pressure+"P");
        System.out.println("Today humidity is "+humidity+"C");
    }
}
