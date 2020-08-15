package com.wushen.desinpattern.builder.improve;

import com.wushen.desinpattern.builder.improve.House;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:41
 */
public abstract  class HouseBuilder {
    /*组合关系*/
    protected House house = new House();

    // 将建造的流程写好,抽象的方法
    abstract void builderBasic();
    abstract void builderWall();
    abstract void roofed();

    // 建造房子,将产品(房子)返回,依赖关系
    public House buildHouse(){
        return house;
    }
}
