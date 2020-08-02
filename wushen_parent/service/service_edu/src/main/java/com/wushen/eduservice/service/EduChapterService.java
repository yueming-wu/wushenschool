package com.wushen.eduservice.service;

import com.wushen.eduservice.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wushen.eduservice.entity.EduVideo;
import com.wushen.eduservice.entity.chapter.ChapterVO;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVO> getChaptersAndVideosByCourseId(String courseId);

    List<EduChapter> getChaptersByCourseId(String courseId);

    List<EduVideo> getVideosByCourseId(String courseId);

    boolean deleteChapterById(String chapterId);

    void deleteChapterByCourseId(String courseId);
}
