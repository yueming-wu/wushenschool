package com.wushen.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushen.eduservice.entity.EduTeacher;
import com.wushen.eduservice.mapper.EduTeacherMapper;
import com.wushen.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author wushenjava
 * @since 2020-07-29
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public List<EduTeacher> selectFamousTeacher() {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        wrapper.last("limit 4");
        List<EduTeacher> teacherList = baseMapper.selectList(wrapper);
        return teacherList;
    }
}
