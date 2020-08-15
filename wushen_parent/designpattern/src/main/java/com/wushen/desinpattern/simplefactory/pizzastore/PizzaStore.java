package com.wushen.desinpattern.simplefactory.pizzastore;

import com.wushen.desinpattern.simplefactory.SimpleFactory;
import com.wushen.desinpattern.simplefactory.order.OrderPizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 10:12
 */
public class PizzaStore {
    public static void main(String[] args) {
        /*该类是披萨商店就像客户端一样,new相当于一次请求*/
        //new OrderPizza();
        new OrderPizza(new SimpleFactory());
    }
}
