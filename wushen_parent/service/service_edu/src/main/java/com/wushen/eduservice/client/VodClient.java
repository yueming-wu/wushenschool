package com.wushen.eduservice.client;

import com.wushen.commonutils.R;
import com.wushen.eduservice.client.impl.VodFileDegradeFeignClient;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-03 8:15
 */
@Component //将接口交给spring管理
@FeignClient(name = "service-vod",fallback = VodFileDegradeFeignClient.class) //指明该调用者客户端所调的服务名
public interface VodClient {
    @DeleteMapping("/eduvod/video/{videoId}") //注意出一定要写完全匹配路径;//必须指定参数名称
    public R deleteVideoByVideoId(@PathVariable("videoId") String videoId);
    @DeleteMapping ("/eduvod/video/deleteVideoByBatch")
    public R deleteVideoByBatch(@RequestParam("videoList") List<String> videoList);
}
