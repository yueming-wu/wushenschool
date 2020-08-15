package com.wushen.desinpattern.methodfactory.order;


import com.wushen.desinpattern.methodfactory.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 9:27
 */
public abstract class OrderPizza {
    /*构造法循环订购披萨目的是只要已下单就产生披萨*/
    public OrderPizza(){
        String pizzaType = null;
        System.out.println("工厂方法创建"+pizzaType+"类型的披萨");
        do {
            /*必须放入循环里否则无法提供新的变量无法退出*/
            pizzaType = this.getPizzaType();
            Pizza pizza = createPizza(pizzaType);
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

    public  abstract Pizza createPizza(String pizzaType) ;

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
