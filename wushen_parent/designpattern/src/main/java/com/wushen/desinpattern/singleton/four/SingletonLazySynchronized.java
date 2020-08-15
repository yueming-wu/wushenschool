package com.wushen.desinpattern.singleton.four;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 7:25
 */
public class SingletonLazySynchronized {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance == singleton);
        System.out.println(instance.hashCode()+" == "+singleton.hashCode());
    }
}
class Singleton{
    private static Singleton singleton;
    private Singleton(){}
    public static synchronized    Singleton getInstance(){
        if (singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
