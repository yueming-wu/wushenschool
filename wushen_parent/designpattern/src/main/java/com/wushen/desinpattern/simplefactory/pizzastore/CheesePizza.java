package com.wushen.desinpattern.simplefactory.pizzastore;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 9:55
 */
public class CheesePizza extends Pizza{
    @Override
    public  void prepare() {
        System.out.println("准备奶酪披萨原材料");
    }
}
