package com.wushen.eduservice.service;

import com.wushen.eduservice.entity.EduVideo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author wushenjava
 * @since 2020-08-01
 */
public interface EduVideoService extends IService<EduVideo> {

    void deleteVideoByCourseId(String courseId);
}
