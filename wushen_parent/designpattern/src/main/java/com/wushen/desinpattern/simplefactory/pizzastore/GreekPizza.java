package com.wushen.desinpattern.simplefactory.pizzastore;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 9:56
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备希腊披萨原材料");
    }
}
