package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:27
 */
public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("来自男人的失败");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("来自于女人的失败");
    }
}
