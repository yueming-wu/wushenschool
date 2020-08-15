package com.wushen.desinpattern.adapter.client;

import com.wushen.desinpattern.adapter.adapter.VoltageAdapter;
import com.wushen.desinpattern.adapter.adapter.VoltageAdapterObject;
import com.wushen.desinpattern.adapter.adapter.VoltageInterfaceAdapter;
import com.wushen.desinpattern.adapter.product.Phone;
import com.wushen.desinpattern.adapter.source.Voltage220;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 16:11
 */
public class Client {
    public static void main(String[] args) {
        Phone phone = new Phone();
//        phone.charging(new VoltageAdapter());
//        phone.charging(new VoltageAdapterObject(new Voltage220()));
        new VoltageInterfaceAdapter(){
            @Override
            public void m4() {
                /*只想适配m4*/
                super.m4();
            }
        };
    }
}
