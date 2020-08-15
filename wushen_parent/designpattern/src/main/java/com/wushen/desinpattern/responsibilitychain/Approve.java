package com.wushen.desinpattern.responsibilitychain;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 16:54
 */
public abstract class Approve {
    /*下一处理者*/
    protected Approve next;
    protected String name;
    /*根据指定的名字创建处理者*/
    public Approve(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*设置下一个处理者*/
    public void setNext(Approve next) {
        this.next = next;
    }

    /*处理请求,一个请求的处理条件不同无法统一实现交由子类处理*/
    public abstract void processApprove(PurchaseRequest request);
}
