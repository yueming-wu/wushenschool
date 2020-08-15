package com.wushen.desinpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 9:55
 */
public class Department extends OrganizationComponent {
   /*此处是叶子节点,不需要再聚合其他节点了*/
    public Department(String name, String description) {
        super(name, description);
    }
    /*也没有相应的添加删除方法*/
    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDescription() {
        return super.getDescription();
    }

    @Override
    protected void print() {
        System.out.println("我是Leaf,不管了其他节点");
        System.out.println("============"+getName()+"============");
    }
}
