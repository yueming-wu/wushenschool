package com.wushen.eduservice.controller.front;

import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.EduCourse;
import com.wushen.eduservice.entity.EduTeacher;
import com.wushen.eduservice.service.EduCourseService;
import com.wushen.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 @descriptions 前台首页管理
 @author wushen
 @create 2020-07-23 16:22
 */
@Api(tags = "前台首页管理")
@RestController
@CrossOrigin
@RequestMapping("/eduservice/index")
public class IndexController {
    @Autowired
    private EduTeacherService eduTeacherService;
    @Autowired
    private EduCourseService eduCourseService;
    @ApiOperation("查询首页热门课程和名流名师")
    @GetMapping("/getHotCourseAndFamousTeacher")
    private R getHotCourseAndFamousTeacher(){
        /*根据排名查询前4名名师讲师*/
        List<EduTeacher> teacherList = eduTeacherService.selectFamousTeacher();
        /*根据观看次数查询前8门热门课程*/
        List<EduCourse>  courseList = eduCourseService.selectHotCourses();
        return R.ok().data("teacherList",teacherList).data("courseList",courseList);
    }
}
