package com.yqlcode.serviceEdu.controller;


import com.yqlcode.commonUtils.ApiResult;
import com.yqlcode.serviceBase.exceptionHandler.GuliException;
import com.yqlcode.serviceEdu.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-05-14
 */
@RestController
@RequestMapping("/serviceEdu/edu-subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    EduSubjectService eduSubjectService;

    @PostMapping(value = "addSubject")
    public ApiResult addSubject(MultipartFile multipartFile) {
        if (null == multipartFile) {
            throw new GuliException(20001, "文件解析错误，文件为空");
        }
        eduSubjectService.addSubject(multipartFile, eduSubjectService);
        return ApiResult.success();
    }
}

