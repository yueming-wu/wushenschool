package com.wushen.desinpattern.singleton.eight;

import javax.sound.midi.Soundbank;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 8:18
 */
public class EnumSingleton {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        instance.sayOk();
        Singleton singleton = Singleton.INSTANCE;
        System.out.println(instance==singleton);
        System.out.println(instance.hashCode()+"=="+singleton.hashCode());

    }
}
/*枚举类型是JDK5以后加的,它可以保证线程安全但不能显式实现懒加载,
也不是饿汉式,只是随时调用,也相当于懒加载*/
enum Singleton{
    /*枚举类型的属性变量*/
    INSTANCE;
    /*枚举类型的行为方法*/
    public void sayOk(){
        System.out.println("hello,enum");
    }
}
