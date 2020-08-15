package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:24
 */
public abstract class Action {
    public abstract void getManResult(Man man);
    public abstract void getWomanResult(Woman woman);
}
