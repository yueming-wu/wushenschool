package com.wushen.desinpattern.singleton.one;

/**
 @descriptions
 @author wushen
 @create 2020-08-10 22:56
 */
public class HungryStaticConstant {
    public static void main(String[] args) {
        //Singleton singleton = new Singleton();提示报错,不允许外部程序私自创建
        Singleton instance = Singleton.getInstance();
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance == singleton);
        System.out.println(instance.hashCode()+"===="+singleton.hashCode());
    }
}
class Singleton{
    /*内部创造对象即实例化操作,通过静态常量*/
    private final static Singleton SINGLETON = new Singleton();
    /*私有化构造方法,不允许外部程序私自new*/
    private Singleton(){}
    /*仅向外部程序提供一个获取实例的静态方法*/
    public static Singleton getInstance(){
        return SINGLETON;
    }
}
