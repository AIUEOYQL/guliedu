package com.yqlcode.serviceBase.exceptionHandler;/**
 * 描述:
 * 包名:com.yqlcode.serviceBase.exceptionHandler
 * 版本信息: 版本1.0
 * 日期:2021/5/3
 * Copyright 三合力通科技有限公司
 */


import com.yqlcode.commonUtils.ApiResult;
import com.yqlcode.commonUtils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/3 23:02  
 */

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    //指定捕获什么异常
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResult error(Exception e) {
        e.printStackTrace();
        return ApiResult.error().message("捕获到了全局异常");
    }

    //捕获自定义异常
    @org.springframework.web.bind.annotation.ExceptionHandler(GuliException.class)
    @ResponseBody
    public ApiResult error(GuliException e) {
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();
        return ApiResult.error().code(e.getCode()).message(e.getMsg());
    }
}
