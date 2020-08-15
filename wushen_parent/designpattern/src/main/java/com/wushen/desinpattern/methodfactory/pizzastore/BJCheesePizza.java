package com.wushen.desinpattern.methodfactory.pizzastore;

import com.wushen.desinpattern.methodfactory.Pizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 19:43
 */
public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京奶酪披萨");
        System.out.println("准备北京奶酪披萨原材料");
    }
}
