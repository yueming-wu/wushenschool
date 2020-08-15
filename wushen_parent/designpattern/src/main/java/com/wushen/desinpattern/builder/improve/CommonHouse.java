package com.wushen.desinpattern.builder.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:43
 */
public class CommonHouse extends HouseBuilder{
    @Override
    void builderBasic() {
        System.out.println("普通房子打地基5m");
    }

    @Override
    void builderWall() {
        System.out.println("普通房子砌墙10cm");
    }

    @Override
    void roofed() {
        System.out.println("普通房子封顶");
    }
}
