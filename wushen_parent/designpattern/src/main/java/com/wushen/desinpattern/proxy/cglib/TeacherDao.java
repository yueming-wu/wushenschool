package com.wushen.desinpattern.proxy.cglib;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 20:12
 */
public class TeacherDao {
    public void teach(){
        System.out.println("我是cglib要代理的目标类");
    }
}
