package com.wushen.desinpattern.builder.improve;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 13:45
 */
public class Client {
    public static void main(String[] args) {

        System.out.println("输出流程");
        // 盖普通房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备创建房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);

        // 完成盖房子，返回产品（普通房子）
        House house = houseDirector.constructHouse();

        System.out.println("---------------------------------------");

        // 盖高楼
        HighBuilding highBuilding = new HighBuilding();
        // 重置建造者
        houseDirector.setHouseBuilder(highBuilding);
        // 完成盖房子，返回产品（高楼）
        houseDirector.constructHouse();
        StringBuilder stringBuilder = new StringBuilder("hello,word");
        System.out.println(stringBuilder);
    }
}
