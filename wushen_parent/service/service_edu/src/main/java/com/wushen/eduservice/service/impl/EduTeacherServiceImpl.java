package com.wushen.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wushen.eduservice.entity.EduTeacher;
import com.wushen.eduservice.mapper.EduTeacherMapper;
import com.wushen.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> getTeacherListShowByPage(Page<EduTeacher> pageParam) {
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("sort");
        baseMapper.selectPage(pageParam,wrapper);
        /*总条目*/
        List<EduTeacher> records = pageParam.getRecords();
        /*当前页*/
        long current = pageParam.getCurrent();
       /*总页数*/
        long pages = pageParam.getPages();
        /*页容量*/
        long size = pageParam.getSize();
        /*总记录*/
        long total = pageParam.getTotal();
        /*是否有下一页*/
        boolean hasNext = pageParam.hasNext();
        /*是否有上一页*/
        boolean hasPrevious = pageParam.hasPrevious();
        /*把数据放到map集合中*/
        Map<String, Object> map = new HashMap<>(16);
        map.put("items", records);
        map.put("current", current);
        map.put("pages", pages);
        map.put("size", size);
        map.put("total", total);
        map.put("hasNext", hasNext);
        map.put("hasPrevious", hasPrevious);
        /*记住必须返回map*/
        return map;
    }
}
