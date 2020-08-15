package com.wushen.desinpattern.facade;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 11:28
 */
public class Projector {
    /*静态volatile变量+synchronized+双重检查*/
    private static volatile Projector projector;
    private Projector(){}
    public static Projector getInstance(){
        /*第一重检查没有进入到代码块拿到锁时是否为null*/
        if (projector == null) {
            /*进入同步代码块并拿到锁*/
            synchronized (Projector.class){
                /*第一个拿到锁并离开了且释放了锁第二个拿到了锁判断是否为null*/
                if (projector == null ) {
                    /*第一个拿到了锁且判断为空后创建了实例*/
                    projector = new Projector();
                }
            }
        }
        return projector;
    }
    public void on(){
        System.out.println("projector on");
    }
    public void off(){
        System.out.println("projector off");
    }
    public void focus(){
        System.out.println("projector is focus");
    }
    public void pause(){
        System.out.println("projector is paused");
    }
    /*其他方法*/
}
