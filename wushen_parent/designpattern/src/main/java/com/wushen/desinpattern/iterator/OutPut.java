package com.wushen.desinpattern.iterator;

import java.util.Iterator;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 15:38
 */
public class OutPut {
    /*拿到学院集合*/
    private List<Collage> collageList;

    public OutPut(List<Collage> collageList) {
        this.collageList = collageList;
    }
    /*输出所有的学院,然后调用输出系的方法*/
    public void printCollages(){
        Iterator<Collage> iterator = collageList.iterator();
        while (iterator.hasNext()){
            Collage collage = iterator.next();
            System.out.println("学院名称"+collage.getName());
            /*得到对应的迭代器*/
            printDepartments(collage.createIterator());
        }
    }
    /*输出系*/
    public void printDepartments(Iterator iterator){
        while (iterator.hasNext()) {
            Department department = (Department) iterator.next();
            System.out.println(department.getName());
        }
    }
}
