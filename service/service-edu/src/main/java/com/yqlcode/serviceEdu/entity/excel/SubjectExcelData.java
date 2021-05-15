package com.yqlcode.serviceEdu.entity.excel;/**
 * 描述:
 * 包名:com.yqlcode.serviceEdu.entity.excel
 * 版本信息: 版本1.0
 * 日期:2021/5/14
 * Copyright XXXX科技有限公司
 */


import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/14 18:29  
 */
@Data
public class SubjectExcelData {
    /**
     * 一级分类
     * @param null :
     * @throws
     * @return
     * @Author yangqingliang
     * @Date 2021/5/14 18:31
     */
    @ExcelProperty(index = 0)
    private String firstType;

    /**
     * 二级分类
     * @param null :
     * @throws
     * @return
     * @Author yangqingliang
     * @Date 2021/5/14 18:31
     */
    @ExcelProperty(index = 1)
    private String secondType;
}
