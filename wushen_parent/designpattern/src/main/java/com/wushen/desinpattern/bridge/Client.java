package com.wushen.desinpattern.bridge;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 20:31
 */
public class Client {
    public static void main(String[] args) {
        Phone foldedPhone = new FoldedPhone(new HuaWei());
        foldedPhone.open();
        foldedPhone.call();
        foldedPhone.close();
        Phone foldedPhone1 = new FoldedPhone(new Vivo());
        foldedPhone1.open();
        foldedPhone1.call();
        foldedPhone1.close();
    }
}
