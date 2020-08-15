package com.wushen.desinpattern.prototype.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 10:11
 */
public class Client {
    public static void main(String[] args) {
        SheepOne sheepOne = new SheepOne("Tom",1,"白色");
        sheepOne.friend = new SheepOne("jack",2,"黑色");
        SheepOne sheepOne1 = (SheepOne) sheepOne.clone();
        SheepOne sheepOne2 = (SheepOne) sheepOne.clone();
        SheepOne sheepOne3 = (SheepOne) sheepOne.clone();
        SheepOne sheepOne4 = (SheepOne) sheepOne.clone();
        System.out.println(sheepOne);
        System.out.println(sheepOne1+"friend"+sheepOne1.friend.hashCode());
        System.out.println(sheepOne2+"friend"+sheepOne2.friend.hashCode());
        System.out.println(sheepOne3+"friend"+sheepOne3.friend.hashCode());
        System.out.println(sheepOne4+"friend"+sheepOne4.friend.hashCode());
    }
}
