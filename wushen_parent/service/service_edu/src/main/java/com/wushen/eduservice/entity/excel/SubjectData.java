package com.wushen.eduservice.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 @descriptions 课程分类实体;与上传的Excel表格的一级课程和二级课程相对应;其属性来源于Excel表格
 @author wushen
 @create 2020-07-16 14:48
 */
@Data
public class SubjectData {
    //index与表中的列值相对应
    @ExcelProperty(index = 0)
    private String oneSubjectName;
    @ExcelProperty(index = 1)
    private String twoSubjectName;

}
