package com.wushen.desinpattern.singleton.six;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 7:41
 */
public class DuplicationCheck {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton singleton = Singleton.getInstance();
        System.out.println(instance == singleton);
        System.out.println(instance.hashCode()+"===="+singleton.hashCode());
    }
}
class Singleton{
    /*此处volatile时轻量级synchronized,一旦有变化立即加载到内存中*/
    private static volatile Singleton singleton;
    private Singleton (){}
    public static Singleton getInstance(){
        /*第一层检查,判断当前singleton变量是否为null*/
        if (singleton == null ) {
            /*同步代码块,加锁防止多线程篡改,实现线程安全*/
            synchronized (Singleton.class) {
                /*第二层检查,当有第二线程到达时发现singleton不是null则直接返回,效率很好*/
                if (singleton == null ) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
