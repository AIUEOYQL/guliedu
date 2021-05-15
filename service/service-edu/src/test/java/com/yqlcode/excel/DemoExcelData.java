package com.yqlcode.excel;/**
 * 描述:
 * 包名:com.yqlcode.excel
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
 * 2021/5/14 16:52  
 */
@Data
public class DemoExcelData {
    @ExcelProperty(value = "学生编号", index = 0)
    private int studentNo;

    @ExcelProperty(value = "学生姓名",index = 1)
    private String studentName;
}
