package com.wushen.eduservice.controller;


import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.EduCourse;
import com.wushen.eduservice.entity.query.CourseInfoVO;
import com.wushen.eduservice.entity.query.CoursePublishVo;
import com.wushen.eduservice.entity.query.CourseQueryVO;
import com.wushen.eduservice.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Api(tags = "课程管理")
@RestController
@RequestMapping("/eduservice/course")
@CrossOrigin
public class EduCourseController {
    @Autowired
    private EduCourseService eduCourseService;
    @ApiOperation(value = "添加课程",notes = "根据课程查询VO添加课程")
    @PostMapping //注意这种@PostMapping("/")如果前端只写到/eduservice/course则会出现无法匹配现象
    public R addCourse(@ApiParam(name = "courseInfoVO", value = "课程查询VO", required = true)
                       @RequestBody CourseInfoVO courseInfoVO){
        //由于课程大纲需要课程id;故得将id返回给前端
        String cid =eduCourseService.saveCourseInfo(courseInfoVO);
        return R.ok().data("courseId",cid);
    }
    @ApiOperation(value = "查询课程",notes = "根据课程id查询课程信息")
    @GetMapping("/getCourseInfoById/{courseId}")
    public R getCourseInfoById(@ApiParam(name = "courseId", value = "课程id", required = true)
                               @PathVariable String courseId){
        CourseInfoVO courseInfoVO = eduCourseService.getCourseInfoById(courseId);
        return R.ok().data("courseInfo",courseInfoVO);
    }
    @ApiOperation(value = "修改课程",notes = "根据提供的表单修改课程信息")
    @PostMapping("/updateCourseInfo")
    public R updateCourseInfo(@ApiParam(name = "courseInfoVO", value = "课程表单", required = true)
                              @RequestBody CourseInfoVO courseInfoVO){
        eduCourseService.updateCourseInfo(courseInfoVO);
        return R.ok();
    }
    @ApiOperation(value = "查询发布",notes = "根据课程ida查询最终发布信息")
    @GetMapping("/getCoursePublishInfoById/{courseId}")
    public R getCoursePublishInfoById(@ApiParam(name = "courseId",value = "课程id",required = true)
                                      @PathVariable String courseId){
        CoursePublishVo coursePublishVo = eduCourseService.getCoursePublishInfoById(courseId);
        return R.ok().data("coursePublishVo",coursePublishVo);
    }
    @ApiOperation(value = "最终发布",notes = "根据修改课程的状态最终发布信息")
    @PostMapping("/publishCoursePublishInfoByStatus/{courseId}")
    public R publishCoursePublishInfoByStatus(@ApiParam(name = "courseId",value = "课程id",required = true)
                                              @PathVariable String courseId){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(courseId);
        eduCourse.setStatus("Normal");
        eduCourseService.updateById(eduCourse);
        return R.ok();
    }
    @ApiOperation(value = "课程列表",notes = "根据带条件分页查询课程列表信息")
    @PostMapping ("/getCoursesOnConditionByPage/{page}/{limit}")//记住requestBody必须使用PostMapping方式提交数据
    public R getCoursesOnConditionByPage(@ApiParam(name = "page",value = "当前页",required = true) @PathVariable Long page,
                                         @ApiParam(name = "limit",value = "页容量",required = true) @PathVariable Long limit,
                                         @ApiParam(name = "courseQueryVO",value = "查询条件") @RequestBody(required = false) CourseQueryVO courseQueryVO){
        Map<String,Object> map = eduCourseService.getCoursesOnConditionByPage(page,limit,courseQueryVO);
        return R.ok().data(map);
    }
    @ApiOperation(value = "删除课程",notes = "根据课程Id删除课程章节小节描述")
    @DeleteMapping("/{courseId}")
    public R deleteCourseInfosByCourseId(@ApiParam(name = "courseId",value = "课程id",required = true)
                                         @PathVariable String courseId){
        eduCourseService.deleteCourseInfosByCourseId(courseId);
        return R.ok();
    }

}

