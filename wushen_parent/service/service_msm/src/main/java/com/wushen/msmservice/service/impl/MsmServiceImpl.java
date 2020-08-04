package com.wushen.msmservice.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.wushen.msmservice.service.MsmService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 @descriptions
 @author wushen
 @create 2020-08-03 22:35
 */
@Service
public class MsmServiceImpl implements MsmService {
    @Override
    public boolean send(Map<String, Object> param, String phone) {
        /*如果没有手机号则发送失败*/
        if(StringUtils.isEmpty(phone)) return false;
        DefaultProfile profile = DefaultProfile.getProfile("default", "LTAI4G52rGJHv5oEPM2TqMrU",
                "H7TjALyA5DB9ONHMc0uB6daDu9I2WF");
        IAcsClient client = new DefaultAcsClient(profile);
        /*固定参数设置*/
        CommonRequest request = new CommonRequest();
        //request.setProtocol(ProtocolType.HTTPS);
        request.setMethod(MethodType.POST); //请求发送方式必须是Post
        request.setDomain("dysmsapi.aliyuncs.com"); //发送者是阿里云
        request.setVersion("2017-05-25"); //指定发送版本
        request.setAction("SendSms"); //指定发送方法发送短信
        request.putQueryParameter("PhoneNumbers", phone);//接收验证码的手机
        request.putQueryParameter("SignName", "我的武神在线教育网站");//申请阿里云签名名称
        request.putQueryParameter("TemplateCode", "SMS_198930682"); // 申请阿里云模板code
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param)); //验证码数据必须是json
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
            return response.getHttpResponse().isSuccess();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
