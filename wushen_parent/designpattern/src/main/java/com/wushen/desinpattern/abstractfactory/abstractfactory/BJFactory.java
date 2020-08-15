package com.wushen.desinpattern.abstractfactory.abstractfactory;

import com.wushen.desinpattern.abstractfactory.Pizza;
import com.wushen.desinpattern.abstractfactory.pizzastore.BJCheesePizza;
import com.wushen.desinpattern.abstractfactory.pizzastore.BJGreekPizza;


/**
 @descriptions
 @author wushen
 @create 2020-08-11 21:59
 */
public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String pizzaType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza = null;
        if (pizzaType.equals("greek")) {
            pizza =  new BJGreekPizza();
        }else if (pizzaType.equals("cheese")){
            pizza = new BJCheesePizza();
        }/*else if (pizzaType.equals("pepper")) {
            pizza = new CheesePizza();
        }*/else{
            return null;
        }
        return pizza;
    }
}
