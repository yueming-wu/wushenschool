package com.wushen.desinpattern.iterator;

/**
 @descriptions
 @author wushen
 @create 2020-08-14 14:42
 */
public class Department {
    private String name;
    private String description;

    public Department() {
    }
    public Department(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
