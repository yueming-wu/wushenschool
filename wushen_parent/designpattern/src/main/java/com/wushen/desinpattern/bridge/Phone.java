package com.wushen.desinpattern.bridge;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 20:18
 */
public abstract  class Phone {
    private Brand brand;
    /*通过构造方法进行聚合*/
    public Phone(Brand brand) {
        this.brand = brand;
    }
    protected void open(){
        this.brand.open();
    }
    protected void close(){
        this.brand.close();
    }
    protected void call(){
        this.brand.call();
    }

}
