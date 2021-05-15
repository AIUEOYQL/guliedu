package com.yqlcode.serviceEdu.config;/**
 * 描述:
 * 包名:com.yqlcode.serviceEdu.config
 * 版本信息: 版本1.0
 * 日期:2021/5/3
 * Copyright 三合力通科技有限公司
 */


import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/3 13:18  
 */
@Configuration
@MapperScan(basePackages = {"com.yqlcode.serviceEdu.mapper"})
public class EduServiceConfig {
    /**
     * 开启sql性能插件

     * @throws
     * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     * @Author yangqingliang
     * @Date 2021/5/3 13:37
     */
    @Bean
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //ms，超过此处设置的ms则sql不执行
        performanceInterceptor.setMaxTime(1000);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * 逻辑删除插件，3.3.0新版本之后不需要

     * @throws
     * @return com.baomidou.mybatisplus.core.injector.ISqlInjector
     * @Author yangqingliang
     * @Date 2021/5/2 16:38
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 分页查询插件

     * @throws
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @Author yangqingliang
     * @Date 2021/5/3 22:06
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
