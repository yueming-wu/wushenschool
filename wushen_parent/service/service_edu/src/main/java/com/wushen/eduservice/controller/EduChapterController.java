package com.wushen.eduservice.controller;


import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.EduChapter;
import com.wushen.eduservice.entity.chapter.ChapterVO;
import com.wushen.eduservice.service.EduChapterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Api(value = "章节",tags = "后端章节管理")
@RestController
@RequestMapping("/eduservice/chapter")
@CrossOrigin
public class EduChapterController {
    @Autowired
    private EduChapterService eduChapterService;
    @ApiOperation(value = "获取章节和小节",notes = "根据课程id获取课程大纲和小节信息")
    @GetMapping("/getChaptersAndVideos/{courseId}")
    public R getChaptersAndVideos(@ApiParam(name = "courseId",value = "课程id",required = true)
                                  @PathVariable String courseId){
        List<ChapterVO> chaptersAndVideos = eduChapterService.getChaptersAndVideosByCourseId(courseId);
        return R.ok().data("chaptersAndVideos",chaptersAndVideos);
    }
    @ApiOperation(value = "添加章节",notes = "根据章节表单添加章节")
    @PostMapping("/addChapter")
    public R addChapter(@ApiParam(name = "chapter",value = "课程章节",required = true)
                        @RequestBody EduChapter chapter){
        eduChapterService.save(chapter);
        return R.ok();
    }
    @ApiOperation(value = "查询章节",notes = "根据章节id删除章节")
    @GetMapping("/getChapterById/{chapterId}")
    public R getChapterById(@ApiParam(name = "chapterId",value = "章节id",required = true)
                            @PathVariable String chapterId){
        EduChapter chapter = eduChapterService.getById(chapterId);
        return R.ok().data("chapter",chapter);
    }
    @ApiOperation(value = "修改章节",notes = "根据章节表单带id修改章节")
    @PostMapping("/updateChapterById")
    public R updateChapterById(@ApiParam(name = "chapter",value = "课程章节",required = true)
                               @RequestBody EduChapter chapter){
        eduChapterService.updateById(chapter);
        return R.ok();
    }
    @ApiOperation(value = "删除章节",notes = "根据章节id删除章节")
    @DeleteMapping("/deleteChapterById/{chapterId}")
    public R deleteChapterById(@ApiParam(name = "chapterId",value = "章节id",required = true)
                               @PathVariable String chapterId){
        boolean flag = eduChapterService.deleteChapterById(chapterId);
        if (flag){
            return R.ok();
        }else {
            return R.error().data("msg","删除失败");
        }
    }
}

