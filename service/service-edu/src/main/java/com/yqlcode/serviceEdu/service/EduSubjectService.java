package com.yqlcode.serviceEdu.service;

import com.yqlcode.serviceEdu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2021-05-14
 */
public interface EduSubjectService extends IService<EduSubject> {

    void addSubject(MultipartFile multipartFile, EduSubjectService eduSubjectService);
}
