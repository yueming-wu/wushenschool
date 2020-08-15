package com.wushen.desinpattern.methodfactory.client;

import com.wushen.desinpattern.methodfactory.order.BJOrderPizza;
import com.wushen.desinpattern.methodfactory.order.LDOrderPizza;
import com.wushen.desinpattern.methodfactory.pizzastore.BJCheesePizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 20:06
 */
public class PizzaStore {
    public static void main(String[] args) {
        String location = "bj";
        if ("bj".equals(location)) {
            new BJOrderPizza();
        }else {
            new LDOrderPizza();
        }
    }
}
