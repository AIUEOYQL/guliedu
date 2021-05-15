package com.yqlcode.excel;/**
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


    @Override
    public void invoke(SubjectExcelData data, AnalysisContext context) {
        System.out.println("***" + data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }
}
