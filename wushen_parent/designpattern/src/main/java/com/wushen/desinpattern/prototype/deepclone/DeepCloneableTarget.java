package com.wushen.desinpattern.prototype.deepclone;

import java.io.Serializable;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 10:44
 */
public class DeepCloneableTarget implements Serializable,Cloneable {
    public static final long serialVersionUID  = 1L;
    private String cloneName;
    private String cloneClass;

    public DeepCloneableTarget(String cloneName, String cloneClass) {
        this.cloneName = cloneName;
        this.cloneClass = cloneClass;
    }

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public String getCloneClass() {
        return cloneClass;
    }

    public void setCloneClass(String cloneClass) {
        this.cloneClass = cloneClass;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        /*此处所有类型都是String类型使用浅拷贝即可*/
        return super.clone();
    }
}
