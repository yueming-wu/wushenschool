package com.wushen.desinpattern.prototype.deepclone;

import java.io.*;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 10:50
 */
public class DeepProtoType implements Serializable,Cloneable {
    public String name;        // String 属性
    public DeepCloneableTarget target;     // 引用类型属性

    public DeepProtoType() {
        super();
    }

    public DeepProtoType(String name, DeepCloneableTarget target) {
        this.name = name;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepCloneableTarget getTarget() {
        return target;
    }

    public void setTarget(DeepCloneableTarget target) {
        this.target = target;
    }

    /*该方法有两个致命缺点:
            万一原型的属性具有很多个引用类型那岂不是要处理得累死
            万一原型的属性类也具有引用类型那岂不是先处理引用类型的深拷贝！*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object deep = null;
        /*对于自己的基本数据类型和String类型进行浅拷贝类型提升为Object*/
        deep = super.clone();
        /*此时的deep在转化为自己的类型,为处理引用类型做准备*/
        DeepProtoType deepProtoType = (DeepProtoType) deep;
        /*让自己的引用类型克隆自己然后再复制给自己的引用类型,需要类型转换*/
        deepProtoType.target = (DeepCloneableTarget) target.clone();
        /*最终返回处理完毕的具有克隆自己能力的自己*/
        return deepProtoType;
    }
    public Object deepClone(){
        /*创建流*/
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;
        DeepProtoType clone = null;
        try {
            /*序列化*/
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);// 把当前对象以对象流的方式输出
            /*反序列化*/
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            clone = (DeepProtoType) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos!=null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos!=null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis!=null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return clone;
    }
}
