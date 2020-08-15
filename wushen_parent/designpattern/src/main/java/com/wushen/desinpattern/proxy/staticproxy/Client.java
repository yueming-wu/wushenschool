package com.wushen.desinpattern.proxy.staticproxy;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 17:57
 */
public class Client {
    public static void main(String[] args) {
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(new TeacherDao());
        teacherDaoProxy.teach();

    }
}
