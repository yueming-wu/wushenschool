package com.wushen.desinpattern.flyweight;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 16:32
 */
public class Client {
    public static void main(String[] args) {
        WebSiteFactory webSiteFactory = new WebSiteFactory();
        WebSite webSite = webSiteFactory.getWebSiteByType("新闻");
        webSite.use(new User("tom"));
        WebSite webSite1 = webSiteFactory.getWebSiteByType("博客");
        webSite1.use(new User("jack"));
        WebSite webSite2 = webSiteFactory.getWebSiteByType("博客");
        webSite2.use(new User("asura"));
        WebSite webSite3 = webSiteFactory.getWebSiteByType("博客");
        webSite3.use(new User("jimi"));
        System.out.println(webSiteFactory.getCount());
    }
}
