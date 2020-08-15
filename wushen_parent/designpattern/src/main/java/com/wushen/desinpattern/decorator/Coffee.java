package com.wushen.desinpattern.decorator;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 22:46
 */
public  class Coffee extends Drink{
    /*针对单品咖啡价格计算来说就是单价*/
    @Override
    public float cost() {
        return super.getPrice();
    }
}
