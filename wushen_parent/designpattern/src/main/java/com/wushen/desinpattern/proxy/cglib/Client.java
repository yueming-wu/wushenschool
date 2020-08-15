package com.wushen.desinpattern.proxy.cglib;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 20:26
 */
public class Client {
    public static void main(String[] args) {
        TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(new TeacherDao()).getProxyInstance();
        proxyInstance.teach();

    }
}
