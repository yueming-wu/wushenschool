package com.wushen.desinpattern.template.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 21:49
 */
public class Client {
    public static void main(String[] args) {
        SoyMilk pureMilk = new PureMilk();
        pureMilk.make();
        SoyMilk peanutSoyMilk = new PeanutSoyMilk();
        peanutSoyMilk.make();
    }
}
