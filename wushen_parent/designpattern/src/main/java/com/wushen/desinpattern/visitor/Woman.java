package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:26
 */
public class Woman extends Person {
    /*这里使用了双分派,首先在客户端的程序中将具体的参数即action作为状态
    * 传给woman(第一次分派);这个woman类调用作为参数的具体方法
    *getWomanResult()同时将自己作为参数传递进去(第二次分派)
    * */

    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
