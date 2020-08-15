package com.wushen.desinpattern.builder;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:15
 */
public class CommonHouse extends AbstractHouse{
    @Override
    void buildBasic() {
        System.out.println("普通房子 打地基");
    }

    @Override
    void buildWall() {
        System.out.println("普通房子 砌墙");
    }

    @Override
    void roofed() {
        System.out.println("普通房子 封顶");
    }
}
