package com.wushen.desinpattern.simplefactory.order;

import com.wushen.desinpattern.simplefactory.SimpleFactory;
import com.wushen.desinpattern.simplefactory.pizzastore.CheesePizza;
import com.wushen.desinpattern.simplefactory.pizzastore.GreekPizza;
import com.wushen.desinpattern.simplefactory.pizzastore.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 @descriptions
 @author wushen
 @create 2020-08-11 9:27
 */
public class OrderPizza {
    /*构造法循环订购披萨目的是只要已下单就产生披萨*/
   /* public OrderPizza(){
        Pizza pizza = null;
        String pizzaType ;
        do {
            pizzaType = this.getPizzaType();
            if (pizzaType.equals("greek")) {
                pizza =  new GreekPizza();
                pizza.setName("希腊披萨");
                pizza.prepare();
            }else if (pizzaType.equals("cheese")){
                pizza = new CheesePizza();
                pizza.setName("奶酪披萨");
                pizza.prepare();
            }else if (pizzaType.equals("pepper")) {
                pizza = new CheesePizza();
                pizza.setName("胡椒披萨");
                pizza.prepare();
            }else{
                break;
            }
            pizza.bake();
            pizza.cut();
            pizza.box();
        }while (true);
    }*/
    /*聚合方式表示该工厂可有可无*/
    private SimpleFactory simpleFactory;
    /*调用时机是构造订披萨的时候*/
    public OrderPizza (SimpleFactory simpleFactory){
        /*设置聚合关系对象时开始根据订单类型生成披萨*/
        this.setSimpleFactory(simpleFactory);
    }
    /*生成披萨细节*/
    public void setSimpleFactory(SimpleFactory simpleFactory) {
        this.simpleFactory = simpleFactory;
        String pizzaType = null;
        System.out.println("简单工厂创建"+pizzaType+"类型的披萨");
        do {
            /*必须放入循环里否则无法提供新的变量无法退出*/
            pizzaType = this.getPizzaType();
            Pizza pizza = this.simpleFactory.createPizza(pizzaType);
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
