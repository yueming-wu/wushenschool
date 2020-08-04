package com.wushen.msmservice.controller;

import com.wushen.commonutils.R;
import com.wushen.msmservice.service.MsmService;
import com.wushen.msmservice.utils.RandomUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 @descriptions
 @author wushen
 @create 2020-08-03 22:34
 */
@Api(tags = "短信管理")
@RestController
@RequestMapping("/msmservice/sms")
@CrossOrigin
public class MsmController {
    @Autowired
    private MsmService msmService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @ApiOperation(value = "发送短信",notes = "根据验证码和手机号发送短信")
    @GetMapping("/send/{phone}")
    public R sendCode(@ApiParam(name = "phone",value = "手机号",required = true)
                      @PathVariable String phone){
        /*根据手机号获取验证码*/
        String code = redisTemplate.opsForValue().get(phone);
        /*如果Redis当中有验证码,则返回验证码发送成功,表示不会再有效期内进行第二次发送验证码*/
        if (!StringUtils.isEmpty(code)){
            return R.ok().message("短信验证码发送成功");
        }
        /*如果Redis当中没有有验证码,发送验证码*/
        /*随机生成code*/
        code = RandomUtil.getFourBitRandom();
        /*存储到Map中*/
        Map<String,Object> param  = new HashMap<>(16);
        param.put("code",code);
        boolean isSend = msmService.send(param,phone);
        if (isSend){
            /*在第一次发送验证码成功之后将验证码放到Redis当中并设置有效期*/
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return R.ok().message("短信验证码发送成功");
        }else {
            return R.error().message("短信验证码发送成功");
        }
    }
}
