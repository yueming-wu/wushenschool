package com.wushen.eduservice.client.impl;

import com.wushen.commonutils.R;
import com.wushen.eduservice.client.VodClient;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-08-03 10:52
 */
@Component
public class VodFileDegradeFeignClient implements VodClient {
    @Override
    public R deleteVideoByVideoId(String videoId) {
        return R.error().message("删除视频出错");
    }

    @Override
    public R deleteVideoByBatch(List<String> videoList) {
        return R.error().message("批量删除视频出错");
    }
}
