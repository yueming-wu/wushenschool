package com.wushen.desinpattern.observer;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 17:29
 */
public interface Observer {
    /*观察者必须提供要观察的数据及关心数据*/
    void update(float  temperature ,float  pressure,float humidity);
}
