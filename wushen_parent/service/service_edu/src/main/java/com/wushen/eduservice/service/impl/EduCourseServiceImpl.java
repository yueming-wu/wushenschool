package com.wushen.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.baseservice.exception.WuShenException;
import com.wushen.eduservice.entity.EduCourse;
import com.wushen.eduservice.entity.EduCourseDescription;
import com.wushen.eduservice.entity.query.CourseInfoVO;
import com.wushen.eduservice.entity.query.CoursePublishVo;
import com.wushen.eduservice.entity.query.CourseQueryVO;
import com.wushen.eduservice.mapper.EduCourseMapper;
import com.wushen.eduservice.service.EduChapterService;
import com.wushen.eduservice.service.EduCourseDescriptionService;
import com.wushen.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wushen.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {
    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;
    @Autowired
    private EduVideoService eduVideoService;
    @Autowired
    private EduChapterService eduChapterService;

    @Override
    public void updateCourseInfo(CourseInfoVO courseInfoVO) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVO,eduCourse);
        int i = baseMapper.updateById(eduCourse);
        if (i==0){
            throw new WuShenException(20001,"修改课程信息失败");
        }
        EduCourseDescription description = new EduCourseDescription();
        description.setId(courseInfoVO.getId());
        description.setDescription(courseInfoVO.getDescription());
        eduCourseDescriptionService.updateById(description);
    }

    @Override
    public CourseInfoVO getCourseInfoById(String courseId) {
        CourseInfoVO courseInfoVO = new CourseInfoVO();
        EduCourse eduCourse = baseMapper.selectById(courseId);
        BeanUtils.copyProperties(eduCourse,courseInfoVO);
        EduCourseDescription description = eduCourseDescriptionService.getById(courseId);
        courseInfoVO.setDescription(description.getDescription());
        return courseInfoVO;
    }

    @Override
    public String saveCourseInfo(CourseInfoVO courseInfoVO) {
        //  向课程信息表添加课程信息
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoVO,eduCourse);
        //eduCourse.setSubjectParentId("1178214681118568449");
        int insert = baseMapper.insert(eduCourse);
        if (insert == 0 ) {
            throw new WuShenException(20001,"添加课程信息失败");
        }
        //成功添加课程信息后此时eduCourse有自动生成的id;而非courseInfoVO获取等信息
        String cid = eduCourse.getId();
        //  向课程描述表添加描述信息
        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoVO.getDescription());
        //将课程信息的id设置为课程简介的id表明该简介是该课程的简介而非其他课程的简介
        //故此课程信息的id策略改为手动生成;创建时间和修改时间必须自动填充
        eduCourseDescription.setId(cid);
        eduCourseDescriptionService.save(eduCourseDescription);
        return cid;
    }
    @Override
    public CoursePublishVo getCoursePublishInfoById(String courseId) {
        CoursePublishVo coursePublishVo = baseMapper.getCourseInfoById(courseId);
        return coursePublishVo;
    }
    @Override
    public Map<String, Object> getCoursesOnConditionByPage(Long page, Long limit, CourseQueryVO courseQueryVO) {
        //分页插件构造器
        Page<EduCourse> coursePage = new Page<>(page,limit);
        //查询条件构造器
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        String title = null;
        String subjectParentId =null;
        String subjectId = null ;
        String teacherId = null;
        System.out.println(courseQueryVO);
        if (courseQueryVO != null) {
            //        获取条件值
            title = courseQueryVO.getTitle();
            subjectParentId = courseQueryVO.getSubjectParentId();
            subjectId = courseQueryVO.getSubjectId();
            teacherId = courseQueryVO.getTeacherId();
        }
        if (!StringUtils.isEmpty(title)) {
            System.out.println(title);
            queryWrapper.like("title",title);
        }
        if (!StringUtils.isEmpty(subjectParentId)) {
            queryWrapper.eq("subject_parent_id",subjectParentId);
        }
        if (!StringUtils.isEmpty(subjectId)) {
            queryWrapper.eq("subject_id",subjectId);
        }
        if (!StringUtils.isEmpty(teacherId)) {
            queryWrapper.eq("teacher_id",teacherId);
        }
        queryWrapper.orderByDesc("gmt_create");
        this.page(coursePage,queryWrapper);
        List<EduCourse> courses = coursePage.getRecords();
        long total = coursePage.getTotal();
        Map<String,Object>  map = new HashMap<>(16 );
        map.put("courses",courses);
        map.put("total",total);
        return map;
    }

    @Override
    public void deleteCourseInfosByCourseId(String courseId) {
        // 删除小节
        eduVideoService.deleteVideoByCourseId(courseId);
        // 删除章节
        eduChapterService.deleteChapterByCourseId(courseId);
        // 删除描述[它和course的id是一致的;它的id本身就来自于course]
        eduCourseDescriptionService.removeById(courseId);
        int delete = baseMapper.deleteById(courseId);
        if (delete == 0){
            throw new WuShenException(20001,"删除失败");
        }
    }
}
