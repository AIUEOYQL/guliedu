package com.yqlcode.serviceEdu.listener;/**
 * 描述:
 * 包名:com.yqlcode.serviceEdu.listener
 * 版本信息: 版本1.0
 * 日期:2021/5/14
 * Copyright XXXX科技有限公司
 */


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yqlcode.serviceEdu.entity.EduSubject;
import com.yqlcode.serviceEdu.entity.excel.SubjectExcelData;
import com.yqlcode.serviceEdu.service.EduSubjectService;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/14 18:33  
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectExcelData> {
    //引入EduSubjectService方便对数据库进行操作
    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {
    }
    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }


    @Override
    public void invoke(SubjectExcelData subjectExcelData, AnalysisContext analysisContext) {
        EduSubject eduSubjectFirst = existFirstTypeSubject(eduSubjectService, subjectExcelData.getFirstType());
        System.out.println("selected");
        if (null == eduSubjectFirst) {
            eduSubjectFirst = new EduSubject();
            eduSubjectFirst.setParentId("0");
            eduSubjectFirst.setTitle(subjectExcelData.getFirstType());
            System.out.println(eduSubjectFirst);
            eduSubjectService.save(eduSubjectFirst);
        }
        String first_pid = eduSubjectFirst.getId();

        EduSubject eduSubjectSecond = existSecondTypeSubject(eduSubjectService, subjectExcelData.getFirstType(), first_pid);
        if (null == eduSubjectSecond) {
            EduSubject secondSubject = new EduSubject();
            secondSubject.setParentId(first_pid);
            secondSubject.setTitle(subjectExcelData.getSecondType());
            eduSubjectService.save(secondSubject);
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    private EduSubject existFirstTypeSubject(EduSubjectService eduSubjectService,String firstType) {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", firstType);
        queryWrapper.eq("parent_id", 0);
        EduSubject one = eduSubjectService.getOne(queryWrapper);
        return one;
    }

    private EduSubject existSecondTypeSubject(EduSubjectService eduSubjectService,String firstType, String pid) {
        QueryWrapper<EduSubject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("title", firstType);
        queryWrapper.eq("parent_id", pid);
        EduSubject one = eduSubjectService.getOne(queryWrapper);
        return one;
    }
}
