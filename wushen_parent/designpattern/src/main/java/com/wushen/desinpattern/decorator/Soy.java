package com.wushen.desinpattern.decorator;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 23:12
 */
public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        setDescription("豆浆调味品");
        setPrice(1.5f);
    }
}
