package com.wushen.vodservice.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.vod.model.v20170321.DeleteVideoRequest;
import com.aliyuncs.vod.model.v20170321.DeleteVideoResponse;
import com.wushen.baseservice.exception.WuShenException;
import com.wushen.vodservice.service.VideoService;
import com.wushen.vodservice.util.AliyunVodSDKUtils;
import com.wushen.vodservice.util.ConstantPropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-07-22 9:55
 */

@Slf4j
@Service
public class VideoServiceImpl implements VideoService {
    /**
     * @Description: 根据视频id删除视频
     * @Author: wushen
     * @Email:993108679@qq.com
     * @Version: v1.00
     * @Date: 2020/7/22 13:44
     * @Parameters:  * @param videoId
     * @Return void
     * @Throws
     * @param videoId
     */
    @Override
    public void deleteVideoByVideoId(String videoId) {
        try {
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(videoId);
            DeleteVideoResponse response = client.getAcsResponse(request);
            System.out.println(response.getRequestId());
        } catch (ClientException e) {
            e.printStackTrace();
            throw new WuShenException(20001,"删除视频失败");
        }
    }

    /**
     * @Description: 将本地文件上传至阿里云视频点播
     * @Author: wushen
     * @Email:993108679@qq.com
     * @Version: v1.00
     * @Date: 2020/7/22 10:04
     * @Parameters:  * @param file
     * @Return java.lang.String
     * @Throws
     * @param file
     */
    @Override
    public String uploadVideo(MultipartFile file) {
        InputStream inputStream = null;
        try {
            /*根据文件获取输入流*/
            inputStream = file.getInputStream();
            /*上传文件的原始名称*/
            String originalFilename = file.getOriginalFilename();
            /*上传至阿里云视频点播里要显示的文件名称*/
            String title = originalFilename.substring(0, originalFilename.lastIndexOf("."));
            UploadStreamRequest request = new UploadStreamRequest(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET, title, originalFilename, inputStream);
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            String videoId = response.getVideoId();
            if (!response.isSuccess()){
                String errorMessage = "阿里云上传错误：" + "code：" + response.getCode() + ", message：" + response.getMessage();
                log.warn(errorMessage);
                if(StringUtils.isEmpty(videoId)){
                    throw new WuShenException(20001, errorMessage);
                }
            }
            return videoId;
        } catch (IOException e) {
            e.printStackTrace();
            throw new WuShenException(20001, "视频上传失败");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void deleteVideoByBatch(List<String> videoList) {
        try {
            DefaultAcsClient client = AliyunVodSDKUtils.initVodClient(ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET);
            String s = StringUtils.join(videoList.toArray(), ",");
            DeleteVideoRequest request = new DeleteVideoRequest();
            request.setVideoIds(s);
            DeleteVideoResponse response = client.getAcsResponse(request);
            System.out.println(response.getRequestId());
        } catch (ClientException e) {
            e.printStackTrace();
            throw new WuShenException(20001,"批量删除视频id失败");
        }

    }
}
