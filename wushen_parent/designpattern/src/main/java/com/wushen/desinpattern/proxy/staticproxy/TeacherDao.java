package com.wushen.desinpattern.proxy.staticproxy;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 17:49
 */
public class TeacherDao implements ITeacherDao{
    @Override
    public void teach() {
        System.out.println("老师上课");
    }
}
