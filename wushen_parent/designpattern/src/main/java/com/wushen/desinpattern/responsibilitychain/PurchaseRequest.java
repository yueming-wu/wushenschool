package com.wushen.desinpattern.responsibilitychain;

/**
 @descriptions
 @author wushen
 @create 2020-08-15 16:52
 */
public class PurchaseRequest {
    private String type;
    private float price;
    private String id;

    public PurchaseRequest(String type, float price, String id) {
        this.type = type;
        this.price = price;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public float getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
