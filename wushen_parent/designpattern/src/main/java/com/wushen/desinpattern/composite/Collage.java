package com.wushen.desinpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 9:52
 */
public class Collage extends OrganizationComponent {
    /*学校管理类即composite,管理着叶子节点和非叶子节点;通过容器进行增删改*/
    /*注意此处要添加Department*/
    List<OrganizationComponent> organizationComponents = new ArrayList<>(16);

    public Collage(String name, String description) {
        super(name, description);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        /*注意此处添加部门逻辑和添加学院逻辑是不一样的*/
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        /*注意此处添加部门逻辑和添加学院逻辑是不一样的*/
        organizationComponents.remove(organizationComponent);
    }

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
        System.out.println("我是Composite专门系部门");
        System.out.println("============"+getName()+"============");
        /*递归打印子节点方法*/
        for (OrganizationComponent component : organizationComponents) {
            component.print();
        }
    }
}
