package com.wushen.desinpattern.abstractfactory.client;

import com.wushen.desinpattern.abstractfactory.abstractfactory.BJFactory;
import com.wushen.desinpattern.abstractfactory.abstractfactory.LDFactory;
import com.wushen.desinpattern.abstractfactory.order.OrderPizza;
import com.wushen.desinpattern.methodfactory.order.BJOrderPizza;
import com.wushen.desinpattern.methodfactory.order.LDOrderPizza;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 20:06
 */
public class PizzaStore {
    public static void main(String[] args) {
        String location = "bj";
        if ("bj".equals(location)) {
            new OrderPizza(new BJFactory());
        }else {
            new OrderPizza(new LDFactory());
        }
    }
}
