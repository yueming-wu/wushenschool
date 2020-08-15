package com.wushen.desinpattern.builder.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:46
 */
public class HighBuilding extends HouseBuilder {
    @Override
    void builderBasic() {
        System.out.println("高楼打地基100m");
    }

    @Override
    void builderWall() {
        System.out.println("高楼砌墙20cm");
    }

    @Override
    void roofed() {
        System.out.println("高楼的透明屋顶");
    }
}
