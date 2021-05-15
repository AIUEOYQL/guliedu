package com.yqlcode.serviceBase.exceptionHandler;/**
 * 描述:
 * 包名:com.yqlcode.serviceBase.exceptionHandler
 * 版本信息: 版本1.0
 * 日期:2021/5/4
 * Copyright 三合力通科技有限公司
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/4 11:39  
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GuliException extends RuntimeException{
    /**
     * 异常状态码
     */
    private Integer code;

    /**
     * 异常信息
     */
    private String msg;
}
