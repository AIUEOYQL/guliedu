package com.yqlcode.excel;/**
 * 描述:
 * 包名:com.yqlcode.excel
 * 版本信息: 版本1.0
 * 日期:2021/5/14
 * Copyright XXXX科技有限公司
 */


import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/14 16:55  
 */
public class EasyExcelTest {
    public static void main(String[] args) {
//        String fileName = "D:\\java学习\\谷粒学院\\student.xls";
//        EasyExcel.read(fileName, DemoExcelData.class, new ExcelListener()).sheet().doRead();

        //写excel数据
//        EasyExcel.write(fileName, DemoExcelData.class).sheet("学生档案").doWrite(getData());

        //读取excel数据，需要创建监听器
        String fileName = "D:\\java学习\\谷粒学院\\course2.xls";
        EasyExcel.read(fileName, SubjectExcelData.class, new SubjectExcelListener()).sheet().doRead();

    }

    private static List<DemoExcelData> getData() {
        List<DemoExcelData> data = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            DemoExcelData student = new DemoExcelData();
            student.setStudentNo(i);
            student.setStudentName("nazi" + i);
            data.add(student);
        }
        return data;
    }
}
