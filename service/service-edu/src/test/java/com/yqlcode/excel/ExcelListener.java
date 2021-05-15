package com.yqlcode.excel;/**
 * 描述:
 * 包名:com.yqlcode.excel
 * 版本信息: 版本1.0
 * 日期:2021/5/14
 * Copyright XXXX科技有限公司
 */


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/14 17:12  
 */
public class ExcelListener extends AnalysisEventListener<DemoExcelData> {
    @Override
    public void invoke(DemoExcelData demoExcelData, AnalysisContext analysisContext) {
        System.out.println("***" + demoExcelData);
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println(headMap);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
