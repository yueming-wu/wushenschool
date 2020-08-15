package com.wushen.desinpattern.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 15:47
 */
public class Client {
    public static void main(String[] args) {
        List<Collage> collages = new ArrayList<>();
        ComputerCollage computerCollage = new ComputerCollage();
        InfoCollage infoCollage = new InfoCollage();
        collages.add(computerCollage);
        collages.add(infoCollage);
        OutPut outPut = new OutPut(collages);
        outPut.printCollages();


    }
}
