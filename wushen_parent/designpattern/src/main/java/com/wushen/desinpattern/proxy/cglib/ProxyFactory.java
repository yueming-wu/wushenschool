package com.wushen.desinpattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 20:13
 */
public class ProxyFactory implements MethodInterceptor {
    /*声明目标对象*/
    private Object target;
    /*传入被代理的对象*/
    public ProxyFactory(Object target) {
        this.target = target;
    }
    /*返回一个目标对象的代理对象*/
    public Object getProxyInstance(){
        /*创建一个工具类*/
        Enhancer enhancer = new Enhancer();
        /*设置它的父类*/
        enhancer.setSuperclass(target.getClass());
        /*设置回调函数*/
        enhancer.setCallback(this);
        /*创建子类对象*/
        return enhancer.create();
    }
    /*重写该方法,会调用目标方法对象*/
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib代理开始");
        Object objectValue = method.invoke(target, args);
        System.out.println("Cglib代理结束,提交");
        return objectValue;
    }
}
