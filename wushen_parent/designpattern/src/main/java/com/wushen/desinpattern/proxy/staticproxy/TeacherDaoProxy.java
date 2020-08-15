package com.wushen.desinpattern.proxy.staticproxy;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 17:51
 */
public class TeacherDaoProxy implements ITeacherDao {
    private ITeacherDao target;//目标对象通过接口来聚合
    public TeacherDaoProxy(ITeacherDao target){
        this.target = target;
    }
    @Override
    public void teach() {
        System.out.println("此处可以扩展很多功能");
        System.out.println("静态代理方法开始");
        target.teach();
        System.out.println("静态代理方法提交");
    }
}
