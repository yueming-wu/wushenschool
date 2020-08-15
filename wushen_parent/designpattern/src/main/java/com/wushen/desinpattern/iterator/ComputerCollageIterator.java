package com.wushen.desinpattern.iterator;

import java.util.Iterator;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 14:44
 */
public class ComputerCollageIterator implements Iterator {
    /*聚合元素,以数组的方式存储计算机学院的下属系*/
    private Department[] departments;
    private int position = 0;
    /*将系部门的赋值时机给为创建学院时*/
    public ComputerCollageIterator(Department[] departments) {
        this.departments = departments;
    }
    /*以数组的方式判断元素是否有下一个元素*/
    @Override
    public boolean hasNext() {
        if (position >= departments.length || departments[position] == null){
            return false;
        }else {
            return true;
        }
    }
    @Override
    public Object next() {
        Department department = departments[position];
        position = position+1;
        return department;
    }
    public void remove(){
        /*空实现*/
    }
}
