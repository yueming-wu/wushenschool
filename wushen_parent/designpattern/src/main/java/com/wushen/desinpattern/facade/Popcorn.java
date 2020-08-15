package com.wushen.desinpattern.facade;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 11:23
 */
public class Popcorn {
    /*饿汉式静态变量加代码块*/
    private static Popcorn popcorn;
    /*代码块*/
    static{
        popcorn = new Popcorn();
        System.out.println("必须是代码块==>"+popcorn);
    }
    private Popcorn(){}
    public static Popcorn getInstance(){
        return popcorn;
    }
    public void on(){
        System.out.println("popcorn on");
    }
    public void off(){
        System.out.println("popcorn off");
    }
    public void pop(){
        System.out.println("popcorn is pop");
    }
    public void pause(){
        System.out.println("popcorn is paused");
    }
    /*其他方法*/
}
