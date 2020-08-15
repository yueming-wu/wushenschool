package com.wushen.desinpattern.adapter.adapter;

import com.wushen.desinpattern.adapter.destination.IVoltage5;
import com.wushen.desinpattern.adapter.source.Voltage220;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 16:27
 */
public class VoltageAdapterObject implements IVoltage5 {
    private Voltage220 voltage220 ;
    public VoltageAdapterObject(Voltage220 voltage220){
        /*将参数赋值给属性此处正真的聚合关系*/
        this.voltage220 = voltage220;
    }
    @Override
    public int outPut5() {
        if(voltage220 != null) {
            int src  = voltage220.outPut220();
            System.out.println("使用对象适配器模式进行适配");
            int dst = src / 44 ;
            return dst;
        }
        return 0;
    }
}
