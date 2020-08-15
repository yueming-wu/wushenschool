package com.wushen.desinpattern.responsibilitychain;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 17:10
 */
public class SchoolApprove extends Approve {
    public SchoolApprove(String name) {
        super(name);
    }

    @Override
    public void processApprove(PurchaseRequest request) {
        if (10000 < request.getPrice() && request.getPrice() <= 50000){
            System.out.println("请求编号:"+request.getId()+"被"+this.getName()+"了");
        }else {
            next.processApprove(request);
        }
    }
}
