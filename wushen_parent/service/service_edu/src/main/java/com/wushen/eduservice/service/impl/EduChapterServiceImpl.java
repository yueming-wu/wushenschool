package com.wushen.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushen.baseservice.exception.WuShenException;
import com.wushen.eduservice.entity.EduChapter;
import com.wushen.eduservice.entity.EduVideo;
import com.wushen.eduservice.entity.chapter.ChapterVO;
import com.wushen.eduservice.entity.chapter.VideoVO;
import com.wushen.eduservice.mapper.EduChapterMapper;
import com.wushen.eduservice.service.EduChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wushen.eduservice.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Autowired
    private EduVideoService eduVideoService;
    @Override
    public List<EduChapter> getChaptersByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        return  baseMapper.selectList(wrapper);
    }

    @Override
    public List<EduVideo> getVideosByCourseId(String courseId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        return eduVideoService.list(wrapper);
    }

    @Override
    public List<ChapterVO> getChaptersAndVideosByCourseId(String courseId) {
        List<EduChapter> chapters = this.getChaptersByCourseId(courseId);
        List<EduVideo> videos = this.getVideosByCourseId(courseId);
        List<ChapterVO> chapterVOList = new ArrayList<>(16);
        if (chapters != null) {
            for (int i = 0; i < chapters.size(); i++) {
            EduChapter eduChapter = chapters.get(i);
            ChapterVO chapterVO = new ChapterVO();
            //  封装除children属性外的属性
            BeanUtils.copyProperties(eduChapter,chapterVO);
            // 封装children里面的video:List<VideoVO>
            List<VideoVO> videoVOList = new ArrayList<>(16);
                if (videos != null) {
                    for (int j = 0; j < videos.size(); j++) {
                        EduVideo eduVideo = videos.get(j);
                        if (eduChapter.getId().equals(eduVideo.getChapterId())) {
                            VideoVO videoVO = new VideoVO();
                            //封装video
                            BeanUtils.copyProperties(eduVideo,videoVO);
                            videoVOList.add(videoVO);
                        }
                    }
                }
            //这一步不能少!!!它是封装ChapterVO的最后一步即封装children属性！！
            chapterVO.setChildren(videoVOList);
            //做完之后将ChapterVO放到list进行返回
            chapterVOList.add(chapterVO);
            }
        }
        return chapterVOList;
    }

    @Override
    public boolean deleteChapterById(String chapterId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("chapter_id",chapterId);
        //先查出该章节下是否有小节
        int count = eduVideoService.count(wrapper);
        if (count>0){
            throw new WuShenException(20001,"不能删除");
        }
        // 删除返回1表示删除成功;0表示失败
        int result = baseMapper.deleteById(chapterId);
        return result>0;
    }

    @Override
    public void deleteChapterByCourseId(String courseId) {
        QueryWrapper<EduChapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        baseMapper.delete(wrapper);
    }
}
