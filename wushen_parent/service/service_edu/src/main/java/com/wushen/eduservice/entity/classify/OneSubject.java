package com.wushen.eduservice.entity.classify;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 @descriptions 一级分类
 @author wushen
 @create 2020-07-18 20:47
 */
@Data
public class OneSubject {
    private String id;
    private String title;
    //建立层级关系即一级有多个二级实体类
    private List<TwoSubject> children = new ArrayList<>(16);
}
