package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:26
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
