package com.wushen.desinpattern.decorator;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 22:54
 */
public class Decorator extends Drink {
    private Drink drink;
    public Decorator(Drink drink){
        /*具体联系在一起了,即drink对象装配时机;没有的话下面会空指针*/
        this.drink = drink;
    }
    /*计算价格:装饰品价格+被装饰品价格*/
    @Override
    public float cost() {
        /*装饰品的价格;父类只是定义子类有什么,
        在子类当中用super关键字表示父类引用指向
        子类对象,即当前对象的价格即装饰品价格*/
        /*此处会叠加处理即递归计算价格*/
        return super.getPrice()+drink.cost();
    }

    @Override
    public String getDescription() {
        return "des"+super.getDescription()+"&&"+drink.getDescription();
    }
}
