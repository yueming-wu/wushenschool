package com.wushen.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.EduTeacher;
import com.wushen.eduservice.entity.query.TeacherQueryVO;
import com.wushen.eduservice.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import sun.net.TelnetInputStream;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-07-29
 */
@Api(value = "讲师",tags = "后台讲师管理")
@RestController
@RequestMapping("/eduservice/teacher")
@CrossOrigin
@Slf4j
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;
    @ApiOperation(value = "获取讲师",notes = "获取讲师列表")
    @GetMapping("/findAll")
    public R getTeachers(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("list",list);
    }
    @ApiOperation(value = "删除讲师",notes = "根据id逻辑删除讲师")
    @DeleteMapping("/{id}")
    public R removeTeacherById(@ApiParam(name = "id",value = "讲师id")
                               @PathVariable String id){
        boolean flag = eduTeacherService.removeById(id);
//        log.info(id);
        if (flag){
            return R.ok();
        }else{
            return R.error();
        }
    }
    @ApiOperation(value = "讲师分页",notes = "根据MP的分页插件分页")
    @GetMapping("/{page}/{limit}")
    public R getTeacherByPage(@ApiParam(name = "page",value = "当前页",required = true)
                              @PathVariable Long page,
                              @ApiParam(name = "limit",value = "页容量",required = true)
                              @PathVariable Long limit){
        /*创建MP的分页插件对象Page*/
        Page<EduTeacher> eduTeacherPage = new Page<>(page, limit);
        eduTeacherService.page(eduTeacherPage,null);
        List<EduTeacher> records = eduTeacherPage.getRecords();
        long total = eduTeacherPage.getTotal();
        return R.ok().data("records",records).data("total",total);
    }
    @ApiOperation(value = "讲师条件",notes = "根据多条件查询并分页显示")
    @PostMapping("/{page}/{limit}")
    public R getTeacherByConditionalAndPage(@ApiParam(name = "page",value = "当前页",required = true)
                                            @PathVariable Long page,
                                            @ApiParam(name = "limit",value = "页容量",required = true)
                                            @PathVariable Long limit,
                                            @ApiParam(name = "teacherQueryVO",value = "多条件查询封装VO",required = false)
                                            @RequestBody(required = false) TeacherQueryVO teacherQueryVO){
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        Page<EduTeacher> eduTeacherPage = new Page<>(page, limit);
        String name = null;
        Integer level = null;
        String begin = null;
        String end = null;
        if (teacherQueryVO != null) {
            name = teacherQueryVO.getName();
            level = teacherQueryVO.getLevel();
            begin = teacherQueryVO.getBegin();
            end = teacherQueryVO.getEnd();
        }
        if (!StringUtils.isEmpty(name)){
            wrapper.like("name",name);
        }
        if (!StringUtils.isEmpty(level)){
            wrapper.eq("level",level);
        }
        if (!StringUtils.isEmpty(begin)){
            wrapper.ge("gmt_create",begin);
        }
        if (!StringUtils.isEmpty(end)){
            wrapper.le("gmt_create",end);
        }
        wrapper.orderByDesc("gmt_create");
        eduTeacherService.page(eduTeacherPage,wrapper);
        List<EduTeacher> records = eduTeacherPage.getRecords();
        long total = eduTeacherPage.getTotal();
        return R.ok().data("records",records).data("total",total);
    }
    @ApiOperation(value = "添加讲师",notes = "根据表单添加讲师信息")
    @PostMapping("/addTeacher")
    public R addTeacher(@ApiParam(name = "eduTeacher",value = "表单信息",required = true)
                        @RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if (save){
            return R.ok();
        }else{
            return R.error();
        }
    }
    @ApiOperation(value = "查询讲师",notes = "根据id查询讲师以便修改讲师")
    @GetMapping("/{id}")
    public R getTeacherById(@ApiParam(name = "id",value = "讲师id",required = true)
                            @PathVariable String id){
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        if (eduTeacher != null) {
            return R.ok().data("eduTeacher",eduTeacher);
        }else{
            return R.error();
        }
    }
    @ApiOperation(value = "更新讲师",notes = "根据id更新讲师信息")
    @PutMapping("/{id}")
    public R updateTeacherById(@ApiParam(name = "id",value = "讲师id",required = true)
                               @PathVariable String id,
                               @ApiParam(name = "eduTeacher",value = "讲师表单",required = true)
                               @RequestBody EduTeacher eduTeacher){
        eduTeacher.setId(id);
        boolean update = eduTeacherService.updateById(eduTeacher);
        if (update){
            return R.ok();
        }else{
            return R.error();
        }
    }

}

