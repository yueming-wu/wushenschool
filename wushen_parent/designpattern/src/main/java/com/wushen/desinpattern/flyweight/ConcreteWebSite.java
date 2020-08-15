package com.wushen.desinpattern.flyweight;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 16:16
 */
public class ConcreteWebSite extends WebSite {
    private String webType = "";//网站发布类型
    public ConcreteWebSite(String webType){
        this.webType = webType;
    }
    @Override
    public void use(User user) {
        System.out.println("网站发布类型是"+webType+user.getUsername()+"正在使用");
    }
}
