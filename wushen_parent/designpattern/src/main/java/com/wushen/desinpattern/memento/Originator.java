package com.wushen.desinpattern.memento;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 22:19
 */
public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    /*保存原始对象状态的对象*/
    public Memento saveState(){
        return new Memento(state);
    }
    /*从备忘录获取一个状态恢复自己的状态*/
    public void getStateFromMemento(Memento memento){
        this.state = memento.getState();
    }
}
