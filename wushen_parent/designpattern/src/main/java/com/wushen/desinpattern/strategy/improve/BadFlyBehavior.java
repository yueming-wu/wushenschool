package com.wushen.desinpattern.strategy.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 14:57
 */
public class BadFlyBehavior implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("飞的不好");
    }
}
