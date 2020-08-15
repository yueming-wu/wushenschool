package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:25
 */
public abstract class Person {
    /*提供一个方法让访问者可以访问*/
    public abstract void accept(Action action);
}
