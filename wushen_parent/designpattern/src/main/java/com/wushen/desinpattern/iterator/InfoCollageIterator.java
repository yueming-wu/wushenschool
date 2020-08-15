package com.wushen.desinpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 15:03
 */
public class InfoCollageIterator implements Iterator {
    /*以集合的方式存储系部门*/
    private List<Department> departments = new ArrayList<>(16);
    /*游标*/
    private int  index = -1 ;
    /*以构造时机传入系部门*/
    public InfoCollageIterator(List<Department> departments) {
        this.departments = departments;
    }
    /*信息学院自己的hasNext()方法*/
    @Override
    public boolean hasNext() {
        if (index >= departments.size() -1){
            return false;
        }else {
            index+=1;
            return true;
        }
    }
    @Override
    public Object next() {
        return departments.get(index);
    }
    public void remove(){
        /*空实现*/
    }
}
