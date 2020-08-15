package com.wushen.desinpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 15:32
 */
public class InfoCollage implements Collage {
    private List<Department> departments;
    private int numOfDepartments ;
    public InfoCollage(){
        departments = new ArrayList<>(16);
        addDepartment("计算机","电脑");
        addDepartment("网络","网络");
        addDepartment("网线","设备");
    }
    @Override
    public String getName() {
        return "信息学院";
    }

    @Override
    public Iterator createIterator() {
        return new InfoCollageIterator(departments);
    }

    @Override
    public void addDepartment(String name, String description) {
        Department department = new Department(name, description);
        departments.add(department);
    }
}
