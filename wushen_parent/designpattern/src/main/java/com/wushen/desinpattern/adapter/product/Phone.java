package com.wushen.desinpattern.adapter.product;

import com.wushen.desinpattern.adapter.destination.IVoltage5;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 16:04
 */
public class Phone {

    public void charging(IVoltage5 iVoltage5){
        if (5==iVoltage5.outPut5()) {
            System.out.println("电压等于5v可以充电");
        }else{
            System.out.println("电压大于5v手机要爆");
        }
    }
}
