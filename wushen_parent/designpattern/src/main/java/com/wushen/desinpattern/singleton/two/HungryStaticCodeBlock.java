package com.wushen.desinpattern.singleton.two;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 6:56
 */
public class HungryStaticCodeBlock {
    public static void main(String[] args) {
        //Singleton singleton = new Singleton();提示报错,不允许外部程序私自创建
        Singleton instance = Singleton.getInstance();
        System.out.println(instance);//记住代码块和静态代码块加载顺序不一样很有可能赋值为null
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance == singleton);
//        System.out.println(instance.hashCode()+"===="+singleton.hashCode());

    }
}
class Singleton{
    /*声明静态变量,组合方式表明缺一不可*/
    private static Singleton singleton;
    /*变量使用代码块赋值,在类的装载时调用*/
    {
        singleton = new Singleton();
    }
    /*私有化构造器*/
    private Singleton(){}
    /*给外部程序提供实例对象的方法*/
    public static Singleton getInstance(){
        return singleton;
    }
}
