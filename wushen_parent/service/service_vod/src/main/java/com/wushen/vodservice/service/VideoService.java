package com.wushen.vodservice.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-07-22 9:55
 */
public interface VideoService {
    /**
    * @Description: 将本地文件上传至阿里云视频点播
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/22 10:04
    * @Parameters:  * @param file
    * @Return java.lang.String
    * @Throws
    */
    String uploadVideo(MultipartFile file);
    /**
    * @Description: 根据视频id删除视频
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/22 13:44
    * @Parameters:  * @param videoId
    * @Return void
    * @Throws
    */
    void deleteVideoByVideoId(String videoId);
    /**
     * @Description: 删除多个video视频
     * @Author: wushen
     * @Email:993108679@qq.com
     * @Version: v1.00
     * @Date:  2020/7/22 19:24
     * @Parameters:  * @param videoList
     * @Return void
     * @Throws
     */
    void deleteVideoByBatch(List<String> videoList);
}
