package com.wushen.desinpattern.proxy.dynamicproxy;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 18:38
 */
public class Client {
    public static void main(String[] args) {
       ITeacher proxy = (ITeacher) new ProxyFactory(new TeacherDao()).getProxyInstance();
        System.out.println(proxy.getClass());
        /*注意此处是代理对象调用目标对象,且代理对象是动态生成的*/
        proxy.teach();
    }
}
