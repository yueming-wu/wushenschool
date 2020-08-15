package com.wushen.desinpattern.facade;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 12:02
 */
public class HomeTheaterFacade {
    /*声明变量*/
    /*将各个子系统进行引用依赖即引用声明*/
    private DVDPlayer dvdPlayer;
    private Popcorn popcorn;
    private Projector projector;
    private Screen screen;
    private Stereo stereo;
    private TheaterLight theaterLight;
    /*赋值时机*/
    /*将各个子系统进行聚合进来即引用赋值*/
    public HomeTheaterFacade(){
        super();
        /*饿汉式静态常量*/
        this.dvdPlayer = DVDPlayer.getInstance();
        /*饿汉式静态变量加静态代码块*/
        this.popcorn =  Popcorn.getInstance();
        /*静态volatile变量+synchronized+双重检查*/
        this.projector = Projector.getInstance();
        /*静态内部类+该静态属性为final的静态常量,
        final修饰的变量底层JVM会做处理*+同步外部获取
        实例方法,保证了外部调用是线程安全*/
        this.screen = Screen.getInstance();
        /*枚举常量*/
        this.stereo = Stereo.INSTANCE;
        /*静态内部类+该静态属性为final的静态常量,
        final修饰的变量底层JVM会做处理*+同步外部获取
        实例方法,保证了外部调用是线程安全*/
        this.theaterLight = TheaterLight.getInstance();
    }
    /*第一步准备工作*/
    public void ready(){
        popcorn.on();
        popcorn.pop();
        screen.down();
        projector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }
    /*第二步开始播放*/
    public void play(){
        dvdPlayer.play();
    }
    /*第三步暂停播放*/
    public void pause(){
        dvdPlayer.pause();
    }
    /*第四步结束播放*/
    public void end(){
        popcorn.off();
        theaterLight.bright();
        screen.up();
        projector.off();
        stereo.off();
        dvdPlayer.off();
    }
}
