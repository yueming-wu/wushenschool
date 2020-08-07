package com.wushen.staservice.client;

import com.wushen.commonutils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 @descriptions
 @author wushen
 @create 2020-08-06 9:50
 */
@Component
@FeignClient("service-ucenter")
public interface UcenterClient {
    @GetMapping("/ucenservice/member/countregister/{day}")
    public R registerCount(@PathVariable String day);
}
