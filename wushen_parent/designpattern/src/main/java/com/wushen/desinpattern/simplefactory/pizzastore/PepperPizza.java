package com.wushen.desinpattern.simplefactory.pizzastore;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 10:57
 */
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给胡椒披萨准备原材料");
    }
}
