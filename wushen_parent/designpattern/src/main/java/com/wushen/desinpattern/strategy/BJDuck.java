package com.wushen.desinpattern.strategy;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 14:18
 */
public class BJDuck  extends  Duck{
    @Override
    public void display() {
        System.out.println("这是北京鸭");
    }

    @Override
    public void fly() {
        System.out.println("北京鸭不可以飞翔");
    }
}
