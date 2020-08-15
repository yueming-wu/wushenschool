package com.wushen.desinpattern.proxy.dynamicproxy;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 18:16
 */
public class TeacherDao implements ITeacher {
    @Override
    public void teach() {
        System.out.println("老师正在授课中.....");
    }
}
