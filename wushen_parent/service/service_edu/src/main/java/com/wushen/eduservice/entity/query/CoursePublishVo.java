package com.wushen.eduservice.entity.query;

import lombok.Data;

import java.io.Serializable;

/**
 @descriptions 课程最终发布信息VO
 @author wushen
 @create 2020-07-20 14:44
 */
@Data
public class CoursePublishVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String cover;
    private Integer lessonNum;
    private String subjectLevelOne;
    private String subjectLevelTwo;
    private String teacherName;
    private String price;//只用于显示
}
