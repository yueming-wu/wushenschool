package com.wushen.vodservice.controller;

/**
 @descriptions
 @author wushen
 @create 2020-08-05 16:59
 */

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthRequest;
import com.aliyuncs.vod.model.v20170321.GetVideoPlayAuthResponse;
import com.wushen.baseservice.exception.WuShenException;
import com.wushen.commonutils.R;
import com.wushen.vodservice.util.AliyunVodSDKUtils;
import com.wushen.vodservice.util.ConstantPropertiesUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@Api(tags = "后端视频播放")
@RestController
@RequestMapping("/eduvod/play")
@CrossOrigin
@Slf4j
public class FrontVideoPlayController {
    @ApiOperation(value = "获取凭证",tags = "根据获得视频id获取阿里云视频点播服务")
    @GetMapping("/get-play-auth/{videoId}")
    public R getVideoPlayAuth(@PathVariable("videoId") String videoId)  {
        log.info(videoId);
        //获取阿里云存储相关常量
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        try {
            //初始化
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(accessKeyId, accessKeySecret);
            //请求
            GetVideoPlayAuthRequest request = new GetVideoPlayAuthRequest();
            request.setVideoId(videoId);
            //响应
            GetVideoPlayAuthResponse response = client.getAcsResponse(request);
            //得到播放凭证
            String playAuth = response.getPlayAuth();
            //返回结果
            return R.ok().message("获取凭证成功").data("playAuth", playAuth);
        } catch (Exception e) {
            e.printStackTrace();
            throw new WuShenException(20001,"获取凭证失败");
        }
    }
}
