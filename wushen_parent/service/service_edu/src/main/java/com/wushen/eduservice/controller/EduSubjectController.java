package com.wushen.eduservice.controller;


import com.wushen.commonutils.R;
import com.wushen.eduservice.entity.classify.OneSubject;
import com.wushen.eduservice.service.EduSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Api(tags = "前端学科管理")
@RestController
@RequestMapping("/eduservice/subject")
@CrossOrigin
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;
    @ApiOperation(value = "添加学科",notes = "根据上传的Excel文件添加学科")
    @PostMapping
    public R addSubjectByExcel(@ApiParam(name = "file",value = "Excel文件",required = true)
                                MultipartFile file){
        eduSubjectService.saveSubject(file,eduSubjectService);
        return R.ok();
    }
    @ApiOperation(value = "显示学科",notes = "树形显示学科信息")
    @GetMapping
    public R getSubjectAndShowByTree(){
        //因为一级分类当中包含了二级分类故只需返回一级分类即可
        List<OneSubject> subjects = eduSubjectService.getSubjects();
        return R.ok().data("subjects",subjects);
    }
}

