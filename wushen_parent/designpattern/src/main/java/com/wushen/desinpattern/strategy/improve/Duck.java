package com.wushen.desinpattern.strategy.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 15:09
 */
public abstract class Duck {
    public  FlyBehavior flyBehavior;
    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior = flyBehavior;
    }
    public Duck(){}
    public void quack(){
        System.out.println("鸭子嘎嘎嘎叫");
    }
    public void fly(){
        if (flyBehavior !=null){
            flyBehavior.fly();
        }

    }
    public void swim(){
        System.out.println("鸭子哗啦哗啦游");
    }
    public abstract void  display();
}
