package com.wushen.msmservice.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 @descriptions
 @author wushen
 @create 2020-08-04 8:11
 */
public class RandomUtil {
    /*随机生成器对象*/
    private static final Random random = new Random();
    /*4位小数点格式化对象*/
    private static final DecimalFormat fourdf = new DecimalFormat("0000");
    /*6位小数点格式化对象*/
    private static final DecimalFormat sixdf = new DecimalFormat("000000");
    /*获得4位随机验证码*/
    public static String getFourBitRandom() {
        return fourdf.format(random.nextInt(10000));
    }
    /*获得6位随机验证码*/
    public static String getSixBitRandom() {
        return sixdf.format(random.nextInt(1000000));
    }

    /**
     * 给定数组,抽取n个数据
     * @param list
     * @param n
     * @return
     */
    public static ArrayList getRandom(List list, int n) {

        Random random = new Random();

        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();

        // 生成随机数字并存入HashMap
        for (int i = 0; i < list.size(); i++) {

            int number = random.nextInt(100) + 1;

            hashMap.put(number, i);
        }

        // 从HashMap导入数组
        Object[] robjs = hashMap.values().toArray();

        ArrayList r = new ArrayList();

        // 遍历数组并打印数据
        for (int i = 0; i < n; i++) {
            r.add(list.get((int) robjs[i]));
            System.out.print(list.get((int) robjs[i]) + "\t");
        }
        System.out.print("\n");
        return r;
    }
}
