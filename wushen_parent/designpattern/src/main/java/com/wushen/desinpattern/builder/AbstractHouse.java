package com.wushen.desinpattern.builder;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:14
 */
public  abstract class AbstractHouse {
    // 打地基
    abstract void buildBasic();

    // 砌墙
    abstract void buildWall();

    // 封顶
    abstract void roofed();

    public void build(){
        buildBasic();
        buildWall();
        roofed();
    }
}
