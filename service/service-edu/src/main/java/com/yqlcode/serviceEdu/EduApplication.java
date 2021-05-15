package com.yqlcode.serviceEdu;/**
 * 描述:
 * 包名:com.yqlcode.serviceEdu
 * 版本信息: 版本1.0
 * 日期:2021/5/3
 * Copyright 三合力通科技有限公司
 */


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/3 13:16  
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.yqlcode"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
