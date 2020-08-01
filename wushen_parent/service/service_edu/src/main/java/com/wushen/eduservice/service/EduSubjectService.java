package com.wushen.eduservice.service;

import com.wushen.eduservice.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wushen.eduservice.entity.classify.OneSubject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
public interface EduSubjectService extends IService<EduSubject> {

    void saveSubject(MultipartFile file, EduSubjectService eduSubjectService);

    List<OneSubject> getSubjects();

    List<EduSubject> getOneSubjects();

    List<EduSubject> getTwoSubjects();

}
