package com.wushen.desinpattern.singleton.three;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 7:15
 */
public class SingletonLazyNotSafe {
    public static void main(String[] args) {
//        Singleton singleton = new Singleton();
        Singleton instance = Singleton.getInstance();
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance == singleton);
        System.out.println(instance.hashCode()+"==="+singleton.hashCode());
    }
}
class Singleton{
    private static Singleton singleton;
    private Singleton(){}
    /*只在外部程序调用该实例时进行创建该实例对象*/
    public static Singleton getInstance(){
        if (singleton == null ) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
