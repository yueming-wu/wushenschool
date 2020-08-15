package com.wushen.desinpattern.visitor;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 11:51
 */
public class Client {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.addAttach(new Man());
        objectStructure.addAttach(new Woman());
        objectStructure.addAttach(new Man());
        Success success = new Success();
        objectStructure.display(success);
        Fail fail = new Fail();
        objectStructure.display(fail);
    }
}
