package com.wushen.desinpattern.abstractfactory.abstractfactory;

import com.wushen.desinpattern.abstractfactory.Pizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 21:57
 */
public interface AbsFactory {
    public Pizza createPizza(String pizzaType);
}
