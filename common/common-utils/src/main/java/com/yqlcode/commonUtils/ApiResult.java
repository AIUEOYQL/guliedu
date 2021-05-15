package com.yqlcode.commonUtils;/**
 * 描述:
 * 包名:com.yqlcode.commonUtils
 * 版本信息: 版本1.0
 * 日期:2021/5/3
 * Copyright 三合力通科技有限公司
 */


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @describe：
 * @author: yql/三合力通科技有限公司 
 * @version:v1.0
 * 2021/5/3 17:57  
 */
@Data
public class ApiResult {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回状态码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    private ApiResult() {}

    public static ApiResult success() {
        ApiResult apiResult = new ApiResult();
        apiResult.setSuccess(true);
        apiResult.setCode(ResultCode.SUCCESS);
        apiResult.setMessage("成功");
        return apiResult;
    }

    public static ApiResult error() {
        ApiResult apiResult = new ApiResult();
        apiResult.setSuccess(false);
        apiResult.setCode(ResultCode.ERROR);
        apiResult.setMessage("失败，出错了");
        return apiResult;
    }

    public ApiResult code(Integer code) {
        this.setCode(code);
        return this;
    }

    public ApiResult message(String message) {
        this.setMessage(message);
        return this;
    }

    public ApiResult data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public ApiResult data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
