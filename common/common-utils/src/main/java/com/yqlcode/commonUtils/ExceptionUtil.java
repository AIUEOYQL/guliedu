package com.yqlcode.commonUtils;/**
 * 描述:
 * 包名:com.yqlcode.commonUtils
 * 版本信息: 版本1.0
 * 日期:2021/5/4
 * Copyright 三合力通科技有限公司
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/4 12:14  
 */
public class ExceptionUtil {
    public static String getMessage(Exception e) {
        StringWriter sw = null;
        PrintWriter pw = null;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw);
            // 将出错的栈信息输出到printWriter中
            e.printStackTrace(pw);
            pw.flush();
            sw.flush();
        } finally {
            if (sw != null) {
                try {
                    sw.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (pw != null) {
                pw.close();
            }
        }
        return sw.toString();
    }
}
