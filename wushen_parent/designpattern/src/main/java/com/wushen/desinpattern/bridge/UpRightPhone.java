package com.wushen.desinpattern.bridge;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 20:25
 */
public class UpRightPhone extends Phone {
    public UpRightPhone(Brand brand){
        super(brand);
    }
    protected void open(){
        super.open();
        System.out.println("直立式手机");
    }
    protected void close(){
        super.close();
        System.out.println("直立式手机");
    }
    protected void call(){
        super.call();
        System.out.println("直立式手机");
    }
}
