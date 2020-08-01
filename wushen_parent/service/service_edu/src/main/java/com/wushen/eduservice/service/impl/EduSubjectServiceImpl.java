package com.wushen.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushen.eduservice.entity.EduSubject;
import com.wushen.eduservice.entity.classify.OneSubject;
import com.wushen.eduservice.entity.classify.TwoSubject;
import com.wushen.eduservice.entity.excel.SubjectData;
import com.wushen.eduservice.listener.SubjectExcelListener;
import com.wushen.eduservice.mapper.EduSubjectMapper;
import com.wushen.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public List<OneSubject> getSubjects() {
        // 获取一级分类课程信息
        List<EduSubject> oneSubjects = this.getOneSubjects();
        // 获取二级分类课程信息
        List<EduSubject> twoSubjects = this.getTwoSubjects();
        //最终数据;使用集合装封装后的一级分类
        List<OneSubject> finalSubjects = new ArrayList<>(16);
        if (oneSubjects!=null) {
            //封装一级数据
            for (int i = 0; i < oneSubjects.size(); i++) {
                EduSubject eduSubject = oneSubjects.get(i);
                OneSubject oneSubject = new OneSubject();
//            oneSubject.setId(eduSubject.getId());
//            oneSubject.setTitle(eduSubject.getTitle());
                /*封住一级分类的Id和title*/
                BeanUtils.copyProperties(eduSubject, oneSubject);
                /*使用集合装封装后的二级分类*/
                List<TwoSubject> finalTwoSubjects = new ArrayList<>(16);
                if (twoSubjects!=null) {
                    for (int j = 0; j < twoSubjects.size(); j++) {
                        EduSubject twoEdusubject = twoSubjects.get(j);
                        /*把满足一级条件下的二级分类筛选出来*/
                        if (twoEdusubject.getParentId().equals(eduSubject.getId())) {
                            TwoSubject twoSubject = new TwoSubject();
                            /*封装二级分类的id和title*/
                            BeanUtils.copyProperties(twoEdusubject, twoSubject);
                            /*将封装好的二级分类放入集合中*/
                            finalTwoSubjects.add(twoSubject);
                        }
                    }
                }
                /*将满足一级分类下的所有二级分类以集合的方式封装成为一级分类的子类*/
                oneSubject.setChildren(finalTwoSubjects);
                /*将所有封装好的一级分类装入集合中并返回*/
                finalSubjects.add(oneSubject);
            }
        }
        return finalSubjects;
    }

    @Override
    public List<EduSubject> getOneSubjects() {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id","0");
        wrapper.orderByDesc("sort","id");
        List<EduSubject> oneSubjects = baseMapper.selectList(wrapper);
        return oneSubjects;
    }

    @Override
    public List<EduSubject> getTwoSubjects() {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.ne("parent_id",0);
        wrapper.orderByDesc("sort","id");
        List<EduSubject> twoSubjects = baseMapper.selectList(wrapper);
        return twoSubjects;
    }

    @Override
    public void saveSubject(MultipartFile file, EduSubjectService eduSubjectService) {
        //读取上传过来的Excel文件
        try {
            //上传文件形成的流
            InputStream is = file.getInputStream();
            //EasyExcel通过监听器读取流并根据表格映射的实体类进行生成Sheet然后做读取操作;最终将数据返回给监听器
            EasyExcel.read(is, SubjectData.class,new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
