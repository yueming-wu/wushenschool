package com.wushen.desinpattern.strategy.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 15:16
 */
public class Client {
    public static void main(String[] args) {
        BJDuck bjDuck = new BJDuck();
        bjDuck.display();
        bjDuck.setFlyBehavior(new NoFlyBehavior());
        System.out.println("我认为的北京鸭的行为");
        bjDuck.display();
    }
}
