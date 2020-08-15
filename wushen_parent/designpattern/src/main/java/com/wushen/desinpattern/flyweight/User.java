package com.wushen.desinpattern.flyweight;

/**
 @descriptions
 @author wushen
 @create 2020-08-13 16:43
 */
public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
