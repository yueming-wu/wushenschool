package com.wushen.desinpattern.singleton.five;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 7:34
 */
public class SingletonLazySynchronizedCodeBlock {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance == singleton);
        System.out.println(instance.hashCode() +"=="+ singleton.hashCode());
    }
}
class Singleton{
    private static Singleton singleton;
    private Singleton(){}
    public static Singleton getInstance(){
        if (singleton == null ) {
            synchronized (Singleton.class) {
                singleton = new Singleton();
            }
        }
        return singleton;
    }
}
