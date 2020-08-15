package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:56
 */
public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("来自于男人的待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("来自于女人的待定");
    }
}
