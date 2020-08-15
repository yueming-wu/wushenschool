package com.wushen.desinpattern.abstractfactory.abstractfactory;

import com.wushen.desinpattern.abstractfactory.Pizza;
import com.wushen.desinpattern.abstractfactory.pizzastore.LDCheesePizza;
import com.wushen.desinpattern.abstractfactory.pizzastore.LDGreekPizza;


/**
 @descriptions
 @author wushen
 @create 2020-08-11 22:04
 */
public class LDFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String pizzaType) {
        System.out.println("使用抽象工厂模式");
        Pizza pizza =null;
        if (pizzaType.equals("greek")) {
            pizza =  new LDGreekPizza();
        }else if (pizzaType.equals("cheese")){
            pizza = new LDCheesePizza();
        }/*else if (pizzaType.equals("pepper")) {
            pizza = new CheesePizza();
        }*/else{
            return null;
        }
        return pizza;
    }
}
