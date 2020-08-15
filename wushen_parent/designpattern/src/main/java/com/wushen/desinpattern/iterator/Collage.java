package com.wushen.desinpattern.iterator;

import java.util.Iterator;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 15:08
 */
public interface Collage {
    String getName();
    Iterator createIterator();
    void addDepartment(String name,String description);

}
