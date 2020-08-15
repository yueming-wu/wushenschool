package com.wushen.desinpattern.bridge;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 20:22
 */
public class FoldedPhone extends Phone {
    /*父类已经把默认构造器给屏蔽了子类无法拥有自己的默认构造器
    必须重写有参构造器*/
    public FoldedPhone (Brand brand){
        super(brand);
    }
    protected void open(){
        super.open();
        System.out.println("折叠式手机");
    }
    protected void close(){
        super.close();
        System.out.println("折叠式手机");
    }
    protected void call(){
        super.call();
        System.out.println("折叠式手机");
    }
}
