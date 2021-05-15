package com.yqlcode.serviceEdu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.yqlcode.serviceEdu.entity.EduSubject;
import com.yqlcode.serviceEdu.entity.excel.SubjectExcelData;
import com.yqlcode.serviceEdu.listener.SubjectExcelListener;
import com.yqlcode.serviceEdu.mapper.EduSubjectMapper;
import com.yqlcode.serviceEdu.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2021-05-14
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void addSubject(MultipartFile multipartFile, EduSubjectService eduSubjectService) {
        try {
            EasyExcel.read(multipartFile.getInputStream(), SubjectExcelData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
