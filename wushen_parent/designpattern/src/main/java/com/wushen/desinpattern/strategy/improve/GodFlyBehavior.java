package com.wushen.desinpattern.strategy.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 14:56
 */
public class GodFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("非常擅长飞翔");
    }
}
