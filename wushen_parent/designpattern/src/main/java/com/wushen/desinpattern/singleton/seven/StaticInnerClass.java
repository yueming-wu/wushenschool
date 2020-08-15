package com.wushen.desinpattern.singleton.seven;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 8:08
 */
public class StaticInnerClass {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance == singleton);
        System.out.println(instance.hashCode() +"=="+singleton.hashCode());
    }
}
class Singleton{
    private Singleton(){}
    /*静态内部类,该类有个静态属性*/
    private static class InnerSingletonInstance{
        /*该静态属性为final的静态常量,final修饰的变量底层JVM会做特殊处理*/
        private final static Singleton SINGLETON = new Singleton();
    }
    /*同步外部获取实例方法,保证了外部调用是线程安全*/
    public static synchronized Singleton getInstance() {
        return InnerSingletonInstance.SINGLETON;
    }
}
