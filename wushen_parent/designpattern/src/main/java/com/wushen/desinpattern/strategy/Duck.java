package com.wushen.desinpattern.strategy;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 14:10
 */
public abstract class Duck {
    public Duck(){}
    public void quack(){
        System.out.println("鸭子嘎嘎嘎叫");
    }
    public void fly(){
        System.out.println("鸭子扑哧扑哧飞");
    }
    public void swim(){
        System.out.println("鸭子哗啦哗啦游");
    }
    public abstract void  display();
}
