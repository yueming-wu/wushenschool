package com.wushen.desinpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 16:19
 */
public class WebSiteFactory {
    /*建造一个池*/
    private Map<String,ConcreteWebSite> pool = new HashMap<>(16);
    /*根据网站类型返回一个网站如果没有则重新创建一个*/
    public WebSite getWebSiteByType(String type){
        if (!pool.containsKey(type)) {
            pool.put(type,new ConcreteWebSite(type));
        }
        return pool.get(type);
    }
    /*获取不同网站类型的数量*/
    public int getCount(){
        return pool.size();
    }
}
