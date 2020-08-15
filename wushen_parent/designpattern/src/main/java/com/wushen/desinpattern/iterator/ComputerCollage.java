package com.wushen.desinpattern.iterator;

import java.util.Iterator;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 15:20
 */
public class ComputerCollage implements Collage {
    private Department[] departments;
    private int numOfDepartments ;//保存当前数组的个数
    /*内部自动创建无需外部提供*/
    public ComputerCollage() {
        departments = new Department[5];
        addDepartment("java","老牌");
        addDepartment("php","网站");
        addDepartment("Python","动态");
    }
    @Override
    public String getName() {
        return "计算机学院";
    }

    @Override
    public Iterator createIterator() {
        return new ComputerCollageIterator(departments);
    }

    @Override
    public void addDepartment(String name, String description) {
        Department department = new Department(name, description);
        departments[numOfDepartments] = department;
        numOfDepartments+=1;
    }
}
