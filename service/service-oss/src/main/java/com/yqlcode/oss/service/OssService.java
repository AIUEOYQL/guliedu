package com.yqlcode.oss.service;/**
 * 描述:
 * 包名:com.yqlcode.oss.service
 * 版本信息: 版本1.0
 * 日期:2021/5/11
 * Copyright XXXX科技有限公司
 */


import org.springframework.web.multipart.MultipartFile;

/**
 * @describe：
 * @author: yql/XXXX科技有限公司 
 * @version:v1.0
 * 2021/5/11 19:47  
 */
public interface OssService {
    public String uploadFile(MultipartFile multipartFile);
}
