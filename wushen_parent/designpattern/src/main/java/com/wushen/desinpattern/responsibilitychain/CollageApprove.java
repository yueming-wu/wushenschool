package com.wushen.desinpattern.responsibilitychain;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 17:09
 */
public class CollageApprove extends Approve {
    public CollageApprove(String name) {
        super(name);
    }

    @Override
    public void processApprove(PurchaseRequest request) {
        if (5000 < request.getPrice() && request.getPrice() <= 10000){
            System.out.println("请求编号:"+request.getId()+"被"+this.getName()+"了");
        }else {
            next.processApprove(request);
        }
    }
}
