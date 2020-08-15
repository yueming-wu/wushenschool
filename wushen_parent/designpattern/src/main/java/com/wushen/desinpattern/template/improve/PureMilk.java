package com.wushen.desinpattern.template.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 21:51
 */
public class PureMilk extends SoyMilk {
    @Override
    void addCondiments() {
        System.out.println("元豆浆");
    }
    @Override
    boolean customerWantCondiments() {
        return false;
    }
}
