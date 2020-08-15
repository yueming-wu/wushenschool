package com.wushen.desinpattern.template;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 21:39
 */
public class Client {
    public static void main(String[] args) {
        // 制作红豆豆浆
        System.out.println("-----制作红豆豆浆-----");
        SoyMilk redBeanSoyMilk = new RedBeanSoyMilk();
        redBeanSoyMilk.make();

        // 制作花生豆浆
        System.out.println("-----制作花生豆浆-----");
        SoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();
    }
}
