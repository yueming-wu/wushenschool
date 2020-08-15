package com.wushen.desinpattern.memento;

import com.wushen.desinpattern.adapter.destination.Interface4;

import java.util.ArrayList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 22:27
 */
public class Caretaker {
    /*用于保存转态对象*/
    private List<Memento> mementos = new ArrayList<>(16);
    public void add(Memento memento){
        mementos.add(memento);
    }
    public Memento getIndexMemento(int index){
        return mementos.get(index);
    }
}
