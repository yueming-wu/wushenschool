package com.wushen.desinpattern.facade;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 11:37
 */
public class Screen {
    /*静态内部类+该静态属性为final的静态常量,
    final修饰的变量底层JVM会做处理*+同步外部获取
    实例方法,保证了外部调用是线程安全*/
    private Screen(){}
    /*静态内部类,该类有个静态属性*/
    private static class InnerScreen{
        /*该静态属性为final的静态常量,final修饰的变量底层JVM会做处理*/
        private static final Screen SCREEN = new Screen();
    }
    /*同步外部获取实例方法,保证了外部调用是线程安全*/
    public static synchronized Screen getInstance(){
        return InnerScreen.SCREEN;
    }
    public void up(){
        System.out.println("Screen on");
    }
    public void down(){
        System.out.println("Screen down");
    }
    /*其他方法*/

}
