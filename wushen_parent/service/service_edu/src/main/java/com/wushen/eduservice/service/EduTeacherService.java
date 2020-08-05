package com.wushen.eduservice.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.eduservice.entity.EduTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author wushenjava
 * @since 2020-07-29
 */
public interface EduTeacherService extends IService<EduTeacher> {

    List<EduTeacher> selectFamousTeacher();

    Map<String, Object> getTeacherListShowByPage(Page<EduTeacher> teacherPage);
}
