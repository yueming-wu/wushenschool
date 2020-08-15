package com.wushen.desinpattern.abstractfactory.pizzastore;


import com.wushen.desinpattern.abstractfactory.Pizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 19:46
 */
public class LDGreekPizza extends Pizza {

    @Override
    public void prepare() {
        setName("北京希腊披萨");
        System.out.println("准备北京希腊披萨原材料");
    }
}
