package com.wushen.desinpattern.prototype.deepclone;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 11:13
 */
public class Client {
    public static void main(String[] args) {
        DeepProtoType deepProtoType = new DeepProtoType();
        deepProtoType.setName("宋江");
        DeepCloneableTarget deepCloneableTarget = new DeepCloneableTarget("梁山", "108将");
        deepProtoType.setTarget(deepCloneableTarget);
        try {
//            DeepProtoType deepProtoTypeOne = (DeepProtoType) deepProtoType.clone();
            DeepProtoType deepProtoTypeOne = (DeepProtoType) deepProtoType.deepClone();
            System.out.println(deepProtoType.getName()+deepProtoType.getTarget().hashCode());
            System.out.println(deepProtoTypeOne.getName()+deepProtoTypeOne.getTarget().hashCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
