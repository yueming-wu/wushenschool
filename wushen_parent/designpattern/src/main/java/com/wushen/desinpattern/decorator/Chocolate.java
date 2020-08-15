package com.wushen.desinpattern.decorator;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 23:07
 */
public class Chocolate extends Decorator{
    public Chocolate(Drink drink) {
        super(drink);
        setDescription("巧克力调味品");
        setPrice(3.0f);
    }
}
