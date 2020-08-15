package com.wushen.desinpattern.prototype.client;

import com.wushen.desinpattern.prototype.improve.SheepOne;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 9:25
 */
public class Client {
    public static void main(String[] args) {
        /*Sheep sheep = new Sheep("Tom",1,"白色");
        Sheep sheep1 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep2 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep3 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep4 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        Sheep sheep5 = new Sheep(sheep.getName(), sheep.getAge(), sheep.getColor());
        System.out.println(sheep1);
        System.out.println(sheep2);
        System.out.println(sheep3);
        System.out.println(sheep4);
        System.out.println(sheep5);*/
        SheepOne sheep = new SheepOne("Tom",1,"白色");


    }
}
