package com.wushen.eduservice.controller.front;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.EduCourse;
import com.wushen.eduservice.entity.chapter.ChapterVO;
import com.wushen.eduservice.entity.frontvo.FrontCourseQueryVO;
import com.wushen.eduservice.entity.frontvo.FrontCourseWebVo;
import com.wushen.eduservice.service.EduChapterService;
import com.wushen.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 @descriptions
 @author wushen
 @create 2020-08-05 11:21
 */
@Api(tags = "前端课程管理")
@RestController
@RequestMapping("/eduservice/frontcourse")
@CrossOrigin
public class FrontCourseController {
    @Autowired
    private EduCourseService eduCourseService;
    @Autowired
    private EduChapterService eduChapterService;
    @ApiOperation(value = "课程列表",notes ="根据条件分页显示列表")
    @PostMapping("/{page}/{limit}")
    public R getCourseListByPageAndConditional(@ApiParam(name = "page",value = "当前页",required = true)
                                               @PathVariable Long page,
                                               @ApiParam(name = "limit",value = "页容量",required = true)
                                               @PathVariable Long limit,
                                               @ApiParam(name = "frontCourseQueryVO",value = "前端条件vo",required = false)
                                               @RequestBody(required = false)FrontCourseQueryVO frontCourseQueryVO){
        Page<EduCourse> coursePage = new Page<>(page, limit);
        Map<String,Object> map = eduCourseService.getCourseList(coursePage,frontCourseQueryVO);
        return R.ok().data(map);
    }
    @ApiOperation(value = "课程详情",notes = "根据ID查询课程详情")
    @GetMapping("/getCourseInfo/{courseId}")
    public R getById(@ApiParam(name = "courseId", value = "课程ID", required = true)
                     @PathVariable String courseId){
        //查询课程信息和讲师信息
        FrontCourseWebVo courseWebVo = eduCourseService.selectInfoWebById(courseId);
        //查询当前课程的章节信息
        List<ChapterVO> chapterVoList = eduChapterService.getChaptersAndVideosByCourseId(courseId);
        return R.ok().data("courseWebVo", courseWebVo).data("chapterVoList", chapterVoList);
    }

}
