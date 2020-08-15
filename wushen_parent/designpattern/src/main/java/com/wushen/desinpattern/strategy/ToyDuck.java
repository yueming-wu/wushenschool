package com.wushen.desinpattern.strategy;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 14:21
 */
public class ToyDuck extends Duck {
    @Override
    public void display() {
        System.out.println("这是玩具鸭");
    }

    @Override
    public void quack() {
        System.out.println("玩具鸭不能叫");
    }

    @Override
    public void fly() {
        System.out.println("玩具鸭不能飞翔");
    }

    @Override
    public void swim() {
        System.out.println("玩具鸭不能游泳");
    }
}
