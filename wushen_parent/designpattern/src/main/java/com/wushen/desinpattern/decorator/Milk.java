package com.wushen.desinpattern.decorator;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 23:10
 */
public class Milk extends Decorator{
    public Milk(Drink drink) {
        super(drink);
        setDescription("牛奶调味品");
        setPrice(2.0f);
    }
}
