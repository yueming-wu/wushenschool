package com.wushen.baseservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 @descriptions 自定义异常类
 @author wushen
 @create 2020-07-14 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WuShenException extends RuntimeException{
    private Integer code;
    private String msg;
}
