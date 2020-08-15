package com.wushen.desinpattern.responsibilitychain;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 17:12
 */
public class Master extends Approve {
    public Master(String name) {
        super(name);
    }

    @Override
    public void processApprove(PurchaseRequest request) {
        if (50000 < request.getPrice()){
            System.out.println("请求编号:"+request.getId()+"被"+this.getName()+"了");
        }else {
            next.processApprove(request);
        }
    }
}
