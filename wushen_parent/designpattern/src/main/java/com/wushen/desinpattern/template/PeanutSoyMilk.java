package com.wushen.desinpattern.template;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 21:39
 */
public class PeanutSoyMilk extends SoyMilk {
    @Override
    void addCondiments() {
        System.out.println("加入上好的花生");
    }
}
