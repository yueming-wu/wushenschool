package com.wushen.desinpattern.responsibilitychain;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 17:00
 */
public class DepartmentApprove extends Approve {
    /*必须重写构造方法,因为父类没有默认构造方法*/
    public DepartmentApprove(String name) {
        super(name);
    }


    @Override
    public void processApprove(PurchaseRequest request) {
        if (request.getPrice() <= 5000){
            System.out.println("请求编号:"+request.getId()+"被"+this.getName()+"了");
        }else {
            /*让下一位处理者处理这个要由外部程序指定*/
            next.processApprove(request);
        }
    }
}
