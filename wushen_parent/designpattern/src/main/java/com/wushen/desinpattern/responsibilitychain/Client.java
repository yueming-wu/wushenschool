package com.wushen.desinpattern.responsibilitychain;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 17:13
 */
public class Client {
    public static void main(String[] args) {
        PurchaseRequest purchaseRequest = new PurchaseRequest("1", 20000f, "1");
        DepartmentApprove departmentApprove = new DepartmentApprove("张主任");
        CollageApprove collageApprove = new CollageApprove("李院长");
        SchoolApprove schoolApprove = new SchoolApprove("王副校长");
        Master master = new Master("武校长");
        departmentApprove.setNext(collageApprove);
        collageApprove.setNext(schoolApprove);
        schoolApprove.setNext(master);
        departmentApprove.processApprove(purchaseRequest);
    }
}
