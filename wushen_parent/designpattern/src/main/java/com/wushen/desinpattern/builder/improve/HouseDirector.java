package com.wushen.desinpattern.builder.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:44
 */
public class HouseDirector {
    /*聚合关系*/
    HouseBuilder houseBuilder = null;

    //构造器传入 houseBuilder
    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 通过 setter 方法传入 houseBuilder
    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    // 如何处理建造房子的流程,交给指挥者
    public House constructHouse(){
        houseBuilder.builderBasic();
        houseBuilder.builderWall();
        houseBuilder.roofed();
        return houseBuilder.buildHouse();
    }
}
