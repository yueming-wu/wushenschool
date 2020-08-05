package com.wushen.eduservice.entity.chapter;

import lombok.Data;

import java.io.Serializable;

/**
 @descriptions
 @author wushen
 @create 2020-07-19 17:00
 */
@Data
public class VideoVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private String videoSourceId;
}
