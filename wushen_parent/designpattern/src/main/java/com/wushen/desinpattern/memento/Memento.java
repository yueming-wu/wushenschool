package com.wushen.desinpattern.memento;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 22:19
 */
public class Memento {
    /*原始对象的状态属性*/
    private String state;
    /*构造的时候将原始传入对象的状态属性*/
    public Memento(String state){
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
