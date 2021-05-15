package com.yqlcode.oss.controller;/**
 * 描述:
 * 包名:com.yqlcode.oss.controller
 * 版本信息: 版本1.0
 * 日期:2021/5/11
 * Copyright XXXX科技有限公司
 */


import com.yqlcode.commonUtils.ApiResult;
import com.yqlcode.oss.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/11 19:47  
 */
@RestController
@RequestMapping(value = "eduOssService/file")
@CrossOrigin
@Api("Oss模块")
public class OssController {
    @Autowired
    OssService ossService;

    @ApiOperation("上传文件")
    @PostMapping(value = "uploadFile")
    public ApiResult uploadFile(MultipartFile multipartFile) {
        String fileUrl = ossService.uploadFile(multipartFile);
        return ApiResult.success().data("url", fileUrl);
    }
}
