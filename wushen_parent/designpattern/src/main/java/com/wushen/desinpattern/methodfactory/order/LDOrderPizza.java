package com.wushen.desinpattern.methodfactory.order;

import com.wushen.desinpattern.methodfactory.Pizza;
import com.wushen.desinpattern.methodfactory.pizzastore.BJCheesePizza;
import com.wushen.desinpattern.methodfactory.pizzastore.LDCheesePizza;
import com.wushen.desinpattern.methodfactory.pizzastore.LDGreekPizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 19:55
 */
public class LDOrderPizza extends OrderPizza {
    private Pizza pizza = null;
    @Override
    public Pizza createPizza(String pizzaType) {
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
