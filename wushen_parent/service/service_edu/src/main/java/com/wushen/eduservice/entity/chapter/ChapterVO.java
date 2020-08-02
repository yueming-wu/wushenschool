package com.wushen.eduservice.entity.chapter;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 @descriptions
 @author wushen
 @create 2020-07-19 16:59
 */
@Data
public class ChapterVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private List<VideoVO> children = new ArrayList<>(16);
}
