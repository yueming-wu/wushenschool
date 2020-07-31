package com.wushen.commonutils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 @author yuemingwu
 @create 2020-07-13 21:22
 */
@Data
public class R {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "响应码")
    private Integer code;
    @ApiModelProperty(value = "响应消息")
    private String message;
    @ApiModelProperty(value = "响应数据")
    private Map<String,Object> data = new HashMap<>();
    /*私有化构造方法;只允许本类创建对象*/
    private R(){ }
    /*成功方法;只包含基本信息;成功,成功代码,成功信息*/
    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }
    /*失败方法;只包含基本信息;失败,失败代码,失败信息*/
    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }
    /*success方法,设置成功与否信息,返回当前对象,形成链式编程*/
    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }
    /*code方法,设置成功与否代码,返回当前对象,形成链式编程*/
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    /*message方法,设置成功与否后的信息提示,返回当前对象,形成链式编程*/
    public R message(String message){
        this.setMessage(message);
        return this;
    }
    /*data方法,设置成功与否后的返回数据,返回当前对象,形成链式编程*/
    public R data(String key, Object value){
        this.data.put(key,value);
        return this;
    }
    /*data方法,设置成功与否后的返回数据,返回当前对象,形成链式编程*/
    public R data(Map<String,Object> map){
        this.setData(map);
        return this;
    }
}
