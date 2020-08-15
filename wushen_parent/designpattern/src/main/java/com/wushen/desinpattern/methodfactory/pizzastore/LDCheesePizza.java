package com.wushen.desinpattern.methodfactory.pizzastore;

import com.wushen.desinpattern.methodfactory.Pizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 19:43
 */
public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("伦敦胡椒披萨");
        System.out.println("准备伦敦胡椒披萨原材料");
    }
}
