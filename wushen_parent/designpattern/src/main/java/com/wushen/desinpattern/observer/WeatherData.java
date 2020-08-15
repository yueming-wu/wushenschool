package com.wushen.desinpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 17:40
 */
public class WeatherData implements Subject {
    /*主题子类具体的数据属性也是观察者关心的属性*/
    private float temperature;
    private float pressure;
    private float humidity;
    /*聚合所有观察者*/
    private List<Observer> observers ;
    /*加入所有观察者*/
    public WeatherData() {
        observers = new ArrayList<>(16);
    }
    /*数据更改的时候要通知所有观察者更新*/
    public void dataChange(){
        notifyObservers();
    }
    /*数据填充,由前端决定什么时候算是数据更新来调用此方法*/
    public void setData(float temperature, float pressure, float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        /*自动调用数据变化的方法来更新所有观察者的数据*/
        dataChange();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.contains(observer)) {
            observers.remove(observer);
        }
    }
    /*通知所有的观察者*/
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.temperature,this.pressure,this.humidity);
        }
    }
}
