package com.wushen.eduservice.controller;


import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.EduVideo;
import com.wushen.eduservice.service.EduVideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Api(tags = "小节管理")
@RestController
@RequestMapping("/eduservice/video")
@CrossOrigin
public class EduVideoController {
    @Autowired
    private EduVideoService eduVideoService;
    /*@Autowired
    private VodClient vodClient;*/
    @ApiOperation(value = "添加小节",notes = "根据小节表单添加小节")
    @PostMapping("/addVideo")
    public R addVideo(@ApiParam(name = "eduVideo",value = "小节",required = true)
                      @RequestBody EduVideo eduVideo){
        eduVideoService.save(eduVideo);
        return R.ok();
    }
    @ApiOperation(value = "删除小节",notes = "根据小节id删除小节")
    @DeleteMapping ("/deleteVideoById/{id}")
    public R deleteVideoById(@ApiParam(name = "id",value = "小节id",required = true)
                             @PathVariable String id){
        /*根据id获取视频对象*/
        EduVideo eduVideo = eduVideoService.getById(id);
        /*根据视频对象获得指定的视频来源id*/
        String videoSourceId = eduVideo.getVideoSourceId();
        /*如果不为空则删除小结里面的视频*/
        if (videoSourceId != null) {
            eduVideoService.removeById(videoSourceId);
        }
//        vodClient.deleteVideoByVideoId(id);
        eduVideoService.removeById(id);
        return R.ok();
    }

    @ApiOperation(value = "查询小节",notes ="根据id查询小节")
    @GetMapping("/getVideoById/{id}")
    public R getVideoById(@ApiParam(name = "id",value = "小节id",required = true)
                          @PathVariable String id){
        EduVideo video = eduVideoService.getById(id);
        return R.ok().data("video",video);
    }
    @ApiOperation(value = "修改小节",notes = "根据小节表单的id修改小节")
    @PostMapping ("/updateVideoById")
    public R updateVideoById(@ApiParam(name = "eduVideo",value = "小节",required = true)
                             @RequestBody EduVideo eduVideo){
        eduVideoService.updateById(eduVideo);
        return R.ok();
    }
}

