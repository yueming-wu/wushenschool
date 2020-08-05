package com.wushen.vodservice.controller;

import com.wushen.commonutils.R;
import com.wushen.vodservice.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-07-22 9:44
 */
@Api(value = "视频点播",tags = "后端视频管理")
@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodController {
    @Autowired
    private VideoService videoService;

    @ApiOperation(value = "上传视频",notes = "上传视频到阿里云Vod")
    @PostMapping ("/uploadVideo")
    public R uploadVideo(@ApiParam(name = "file",value = "上传的文件",required = true)
                         @RequestParam("file") MultipartFile file) throws Exception{
       String videoId = videoService.uploadVideo(file);
        return R.ok().data("videoId",videoId);
    }
    @ApiOperation(value = "删除视频",notes = "删除小节里面视频来源id")
    @DeleteMapping("/{videoId}")
    public R deleteVideoByVideoId(@ApiParam(name = "videoId",value = "视频id",required = true)
                                  @PathVariable("videoId") String videoId){
        videoService.deleteVideoByVideoId(videoId);
        return R.ok().message("删除成功");
    }
    @ApiOperation(value = "批量删除",notes = "批量删除小节里面的视频")
    @DeleteMapping ("/deleteVideoByBatch")
    public R deleteVideoByBatch(@ApiParam(name = "id",value = "小节id",required = true)
                                @RequestParam("videoList") List<String> videoList){
        videoService.deleteVideoByBatch(videoList);
        return R.ok();
    }

}
