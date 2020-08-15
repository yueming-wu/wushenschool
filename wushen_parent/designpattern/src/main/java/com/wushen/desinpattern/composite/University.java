package com.wushen.desinpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 9:13
 */
public class University  extends OrganizationComponent{
    /*学校管理类即composite,管理着叶子节点和非叶子节点;通过容器进行增删改*/
    /*注意此处要添加Collage*/
    List<OrganizationComponent> organizationComponents = new ArrayList<>(16);

    public University(String name, String description) {
        super(name, description);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
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
        System.out.println("我是Composite专门管理学院");
        System.out.println("============"+getName()+"============");
        /*递归打印子节点方法*/
        for (OrganizationComponent component : organizationComponents) {
            component.print();
        }
    }
}
