package com.yqlcode.serviceEdu.controller;/**
 * 描述:
 * 包名:com.yqlcode.serviceEdu.controller
 * 版本信息: 版本1.0
 * 日期:2021/5/8
 * Copyright 三合力通科技有限公司
 */


import com.yqlcode.commonUtils.ApiResult;
import org.springframework.web.bind.annotation.*;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/8 13:46  
 */
@RestController
@RequestMapping(value = "eduService/user")
@CrossOrigin
public class EduLoginController {
    @PostMapping(value = "login")
    public ApiResult login() {
        return ApiResult.success().data("token", "admin");
    }

    @GetMapping(value = "info")
    public ApiResult info() {
        return ApiResult.success().data("roles", "admin").data("name", "adminName")
                .data("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
