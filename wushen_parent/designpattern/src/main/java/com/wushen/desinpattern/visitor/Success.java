package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:27
 */
public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("来自于男人的成功");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("来自于女人的成功");
    }
}
