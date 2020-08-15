package com.wushen.desinpattern.simplefactory.pizzastore;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 9:21
 */
/*披萨模板*/
public abstract   class Pizza {
    /*披萨的名称*/
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    /*披萨的准备工作,因为披萨种类原因此处无法具体实现得有具体的子类实现,
        故而设计为抽象方法,因此该类也必须是抽象类,且该方法修饰符为protected*/
    public abstract void prepare();
    /*以下制作工艺大同小异在此处可以具体实现*/
    public void bake(){
        System.out.println(name+"披萨烘烤");
    }
    public void cut(){
        System.out.println(name+"披萨切片");
    }
    public void box(){
        System.out.println(name+"披萨打包");
    }
}
