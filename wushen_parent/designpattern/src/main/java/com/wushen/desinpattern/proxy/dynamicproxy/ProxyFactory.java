package com.wushen.desinpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 18:17
 */
public class ProxyFactory {
    /*通过Object对象将目标对象进行组合进来*/
    private Object target;
    public ProxyFactory(Object target){
        this.target = target;
    }
    /*给目标对象生成一个代理对象*/
    public Object getProxyInstance(){
        /**
        * 1.ClassLoader loader 指定当前目标对象使用的类加载器,获取加载器的方法固定
         2.Class<?> [] interfaces 目标对象实现的接口类型,使用泛型方法确认类型
        * 3.InvocationHandler h:事情处理,执行目标对象的方法时会触发事情处理器方法即
         * 会把当前执行的目标方法作为参数传入,也就是说h会接收到目标对象
        */
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    /*当前代理对象怎么调用目标方法*/
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("JDK 动态代理调用目标方法开始");
                        /*反射机制调用目标对象的方法*/
                        Object objectValue = method.invoke(target, args);
                        System.out.println("JDK 动态代理调用目标方法结束");
                        return objectValue;
                    }
                });
    }
}
