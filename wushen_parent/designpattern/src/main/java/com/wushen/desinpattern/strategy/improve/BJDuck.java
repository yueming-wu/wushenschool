package com.wushen.desinpattern.strategy.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 15:12
 */
public class BJDuck extends Duck {
    public BJDuck(){
        flyBehavior = new GodFlyBehavior();
    }

    @Override
    public void display() {
        System.out.println("北京鸭的行为");
        swim();
        fly();
    }
}
