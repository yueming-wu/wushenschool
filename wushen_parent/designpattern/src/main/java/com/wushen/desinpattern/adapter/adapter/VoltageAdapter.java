package com.wushen.desinpattern.adapter.adapter;

import com.wushen.desinpattern.adapter.destination.IVoltage5;
import com.wushen.desinpattern.adapter.source.Voltage220;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 15:58
 */
public class VoltageAdapter extends Voltage220 implements IVoltage5 {
    @Override
    public int outPut5() {
        int src  = outPut220();
        int dst = src / 44 ;
        return dst;
    }
}
