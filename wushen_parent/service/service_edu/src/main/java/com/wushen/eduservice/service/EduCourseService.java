package com.wushen.eduservice.service;

import com.wushen.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wushen.eduservice.entity.query.CourseInfoVO;
import com.wushen.eduservice.entity.query.CoursePublishVo;
import com.wushen.eduservice.entity.query.CourseQueryVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
public interface EduCourseService extends IService<EduCourse> {

    String saveCourseInfo(CourseInfoVO courseInfoVO);

    CourseInfoVO getCourseInfoById(String courseId);

    void updateCourseInfo(CourseInfoVO courseInfoVO);

    CoursePublishVo getCoursePublishInfoById(String courseId);

    Map<String, Object> getCoursesOnConditionByPage(Long page, Long limit, CourseQueryVO courseQueryVO);

    void deleteCourseInfosByCourseId(String courseId);

    List<EduCourse> selectHotCourses();
}
