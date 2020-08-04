package com.wushen.msmservice.service;

import java.util.Map;

/**
 @descriptions
 @author wushen
 @create 2020-08-03 22:35
 */
public interface MsmService {
    boolean send(Map<String, Object> param, String phone);
}
