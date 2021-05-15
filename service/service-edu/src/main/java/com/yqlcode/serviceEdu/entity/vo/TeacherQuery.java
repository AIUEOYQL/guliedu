package com.yqlcode.serviceEdu.entity.vo;/**
 * 描述:
 * 包名:com.yqlcode.serviceEdu.entity.vo
 * 版本信息: 版本1.0
 * 日期:2021/5/3
 * Copyright 三合力通科技有限公司
 */


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/3 19:25  
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherQuery implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "教师名称,模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师 2首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间", example = "2019-01-01 10:10:10")
    //注意，这里使用的是String类型，前端传过来的数据无需进行类型转换
    private String begin;

    @ApiModelProperty(value = "查询结束时间", example = "2019-12-01 10:10:10")
    private String end;
}
