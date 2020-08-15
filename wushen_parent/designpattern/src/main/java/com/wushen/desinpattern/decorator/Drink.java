package com.wushen.desinpattern.decorator;

/**
 @descriptions
 @author wushen
 @create 2020-08-12 22:42
 */
public abstract class Drink {
    private String description;
    private float price = 0.0F;
    public abstract float  cost();


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
