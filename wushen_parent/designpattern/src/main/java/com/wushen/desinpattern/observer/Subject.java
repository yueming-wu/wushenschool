package com.wushen.desinpattern.observer;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 17:29
 */
public interface Subject {
    /*主题:目标对象,观察者要观察的数据来源*/
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
