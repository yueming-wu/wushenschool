package com.wushen.eduservice.mapper;

import com.wushen.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wushen.eduservice.entity.frontvo.FrontCourseWebVo;
import com.wushen.eduservice.entity.query.CoursePublishVo;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {
    CoursePublishVo getCourseInfoById(String courseId);

    FrontCourseWebVo selectInfoWebById(String courseId);
}
