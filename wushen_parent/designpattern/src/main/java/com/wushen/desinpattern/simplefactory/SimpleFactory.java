package com.wushen.desinpattern.simplefactory;

import com.wushen.desinpattern.simplefactory.pizzastore.CheesePizza;
import com.wushen.desinpattern.simplefactory.pizzastore.GreekPizza;
import com.wushen.desinpattern.simplefactory.pizzastore.Pizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 11:32
 */
public class SimpleFactory {
    private Pizza pizza = null;
    public Pizza createPizza(String pizzaType){
        if (pizzaType.equals("greek")) {
            pizza =  new GreekPizza();
        }else if (pizzaType.equals("cheese")){
            pizza = new CheesePizza();
        }else if (pizzaType.equals("pepper")) {
            pizza = new CheesePizza();
        }else{
            return null;
        }
        return pizza;
    }
}
