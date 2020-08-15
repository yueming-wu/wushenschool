package com.wushen.desinpattern.abstractfactory.order;


import com.wushen.desinpattern.abstractfactory.Pizza;
import com.wushen.desinpattern.abstractfactory.abstractfactory.AbsFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 9:27
 */
public  class OrderPizza {
    private AbsFactory absFactory;
    /*构造法循环订购披萨目的是只要已下单就产生披萨*/
    public OrderPizza(AbsFactory absFactory){
        this.setAbsFactory(absFactory);
    }
    /*具体实现*/
    public void setAbsFactory(AbsFactory absFactory) {
        String pizzaType = null;
        System.out.println("抽象工厂方法创建类型的披萨");
        this.absFactory = absFactory;
        do {
            /*必须放入循环里否则无法提供新的变量无法退出*/
            pizzaType = this.getPizzaType();
            /*订单披萨传入具体的实现子类此处便是谁*/
            Pizza pizza = absFactory.createPizza(pizzaType);
            if (pizza != null) {
                pizza.setName(pizzaType);
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }else {
                System.out.println("退出程序");
                break;
            }
        }while (true);

    }
    /*获取披萨类型*/
    private String getPizzaType(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入您要订购的披萨种类:");
        try {
            String line = reader.readLine();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
