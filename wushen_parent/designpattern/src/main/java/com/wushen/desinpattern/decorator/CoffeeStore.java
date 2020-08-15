package com.wushen.desinpattern.decorator;

import javax.sound.midi.Soundbank;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 23:12
 */
public class CoffeeStore {
    public static void main(String[] args) {
        /*先点咖啡再点调味品*/
        Drink order = new LongBlack();
        System.out.println("langBlack"+order.cost());
        order = new Milk(order);
        System.out.println("order"+order.cost());
    }

}
