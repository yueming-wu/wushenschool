package com.wushen.desinpattern.composite;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 9:06
 */
public abstract class OrganizationComponent {
    private String name;
    private String description;

    public OrganizationComponent() {
    }

    public OrganizationComponent(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected void add(OrganizationComponent organizationComponent){
        /*此处是默认实现,希望有些节点不继承该方法例如叶子节点*/
        throw new UnsupportedOperationException("不支持的操作");
    }
    protected void remove(OrganizationComponent organizationComponent){
        /*此处是默认实现,希望有些节点不继承该方法例如叶子节点*/
        throw new UnsupportedOperationException("不支持的操作");
    }
    /*该方法做成抽象的表示所有该子类必须继承重写*/
    protected abstract void print();
}
