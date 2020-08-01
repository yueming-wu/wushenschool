package com.wushen.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wushen.baseservice.exception.WuShenException;
import com.wushen.eduservice.entity.EduSubject;
import com.wushen.eduservice.entity.excel.SubjectData;
import com.wushen.eduservice.service.EduSubjectService;

/**
 @descriptions 该listener不能交给Spring Ioc容器管理;
 不能注入其他任何依赖,因为即使注入其他地方也使用不上
 @author wushen
 @create 2020-07-16 14:56
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {
    //因此它需要的组件需要自己注入依赖即将其他组件属性话即定义依赖
    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {
    }
    //在构造SubjectExcelListener的时候即注入依赖;注入其他组件
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        /*好处是此处可以调用EduSubjectService的其他任何方法了*/
        this.eduSubjectService = eduSubjectService;
    }
    //一行一行读取数据;但又因为第一列和第二列均是数据库的一条记录且不能重复才可以添加
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData == null) {
            throw new WuShenException(20001,"表格无数据");
        }
        //判断一级分类是否重复
        EduSubject oneSubjectExist = getOneSubjectExist(eduSubjectService, subjectData.getOneSubjectName());
        if (oneSubjectExist == null) {
            oneSubjectExist = new EduSubject();
            oneSubjectExist.setTitle(subjectData.getOneSubjectName());
            oneSubjectExist.setParentId("0");
            eduSubjectService.save(oneSubjectExist);
            //注意不能在这里添加判断二级分类是否重复;它隐藏首层条件是一级分类不存在！！！
            // 即使它不重复添加完成之后也就有id值了！！！
        }
        //判断二级分类是否重复
        EduSubject twoSubjectExist = getTwoSubjectExist(eduSubjectService, subjectData.getTwoSubjectName(),
                oneSubjectExist.getId());
        if (twoSubjectExist == null) {
            twoSubjectExist = new EduSubject();
            twoSubjectExist.setTitle(subjectData.getTwoSubjectName());
            twoSubjectExist.setParentId(oneSubjectExist.getId());
            //来源于mybatis plus自动生成的service内置方法即插入数据库操作
            eduSubjectService.save(twoSubjectExist);
        }

    }
    /**
    * @Description: 判断一级分类是否重复;select*from edu_subject where title =？where parent_id =0
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/16 15:41
    * @Parameters:  * @param eduSubjectService
     * @param name
    * @Return com.wushen.eduservice.entity.EduSubject
    * @Throws
    */
    private EduSubject getOneSubjectExist(EduSubjectService eduSubjectService, String name){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",0);
        return eduSubjectService.getOne(wrapper);
    }
    /**
    * @Description:判断二级分类是否重复;select*from edu_subject where title =？ where parent_id = ？
    * @Author: wushen
    * @Email:993108679@qq.com
    * @Version: v1.00
    * @Date:  2020/7/16 15:43
    * @Parameters:  * @param eduSubjectService
     * @param name
     * @param pid
    * @Return com.wushen.eduservice.entity.EduSubject
    * @Throws
    */
    private EduSubject getTwoSubjectExist(EduSubjectService eduSubjectService, String name, String pid){
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        return eduSubjectService.getOne(wrapper);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
