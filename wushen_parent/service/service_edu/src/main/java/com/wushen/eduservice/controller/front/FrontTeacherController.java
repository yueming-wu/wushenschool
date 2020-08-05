package com.wushen.eduservice.controller.front;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.EduCourse;
import com.wushen.eduservice.entity.EduTeacher;
import com.wushen.eduservice.service.EduCourseService;
import com.wushen.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.font.TextRecord;

import java.util.List;
import java.util.Map;

/**
 @descriptions
 @author wushen
 @create 2020-08-05 9:17
 */
@Api(tags = "前台名师管理")
@RestController
@RequestMapping("/eduservice/front")
@CrossOrigin
public class FrontTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;
    @Autowired
    private EduCourseService eduCourseService;
    @ApiOperation(value = "讲师列表",notes = "分页显示讲师列表")
    @PostMapping("/getTeacherListShowByPage/{page}/{limit}")
    public R getTeacherListShowByPage(@ApiParam(name = "page",value = "当前页",required = true)
                                      @PathVariable Long page,
                                      @ApiParam(name = "limit",value = "页容量",required = true)
                                      @PathVariable Long limit){
        Page<EduTeacher> teacherPage = new Page<>(page, limit);
        Map<String, Object> map = eduTeacherService.getTeacherListShowByPage(teacherPage);
        return R.ok().data(map);
    }
    @ApiOperation(value = "查询详情",notes = "根据讲师id查询讲师信息以及所讲课程")
    @GetMapping("/getTeacherInfoAndCourseInfo/{teacherId}")
    public R getTeacherInfoAndCourseInfo(@ApiParam(name = "teacherId",value = "讲师id",required = true)
                                         @PathVariable String teacherId){
        EduTeacher eduTeacher = eduTeacherService.getById(teacherId);
        QueryWrapper<EduCourse> wrapper = new QueryWrapper<>();
        wrapper.eq("teacher_id",teacherId);
        List<EduCourse> courseList = eduCourseService.list(wrapper);
        return R.ok().data("eduTeacher",eduTeacher).data("courseList",courseList);
    }
}
