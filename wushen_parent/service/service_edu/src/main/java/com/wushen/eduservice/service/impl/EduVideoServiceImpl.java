package com.wushen.eduservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushen.eduservice.entity.EduVideo;
import com.wushen.eduservice.mapper.EduVideoMapper;
import com.wushen.eduservice.service.EduVideoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
@Service
public class EduVideoServiceImpl extends ServiceImpl<EduVideoMapper, EduVideo> implements EduVideoService {
    @Override
    public void deleteVideoByCourseId(String courseId) {
        QueryWrapper<EduVideo> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id",courseId);
        wrapper.select("video_source_id");
        /*先将根据课程id选择多个video对象查出来*/
        List<EduVideo> videos = baseMapper.selectList(wrapper);
        /*将List<EduVideo>转换成为list<String>*/
        ArrayList<String> strings = new ArrayList<>(16);
        for (int i = 0; i < videos.size(); i++) {
            EduVideo video = videos.get(i);
            String videoSourceId = video.getVideoSourceId();
            /*该课程下某个该小节下无视频*/
            if (!StringUtils.isEmpty(videoSourceId)){
                strings.add(videoSourceId);
            }
        }
        /*防止ids为空没必要删除*/
        if (strings.size()>0) {
//            vodClientOne.deleteVideoByBatch(strings);
        }
        baseMapper.delete(wrapper);
    }
}
