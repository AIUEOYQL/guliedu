package com.yqlcode.serviceEdu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yqlcode.commonUtils.ApiResult;
import com.yqlcode.serviceBase.exceptionHandler.GuliException;
import com.yqlcode.serviceEdu.entity.EduTeacher;
import com.yqlcode.serviceEdu.entity.vo.TeacherQuery;
import com.yqlcode.serviceEdu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2021-05-03
 */
@RestController
@RequestMapping("/serviceEdu/edu-teacher")
@CrossOrigin
@Api("谷粒学院-讲师模块")
public class EduTeacherController {

    @Autowired
    EduTeacherService eduTeacherService;

    /**
     * 查询所有数据

     * @throws
     * @return java.util.List<com.yqlcode.serviceEdu.entity.EduTeacher>
     * @Author yangqingliang
     * @Date 2021/5/3 13:45
     */
    @ApiOperation("查询所有讲师信息")
    @GetMapping(value = "listAll")
    public ApiResult listAll() {
        List<EduTeacher> eduTeacherList = eduTeacherService.list(null);

        return ApiResult.success().data("items", eduTeacherList);
    }

    /**
     * 逻辑删除
     * @param id :
     * @throws
     * @return boolean
     * @Author yangqingliang
     * @Date 2021/5/3 17:07
     */
    @ApiOperation("逻辑删除讲师")
    @DeleteMapping(value = "{id}")
    public ApiResult delete(@ApiParam(name = "id", value = "讲师id", required = true)
                              @PathVariable String id) {
        boolean flag = eduTeacherService.removeById(id);
        return flag? ApiResult.success() : ApiResult.error();
    }

    @ApiOperation("分页查询讲师")
    @GetMapping(value = "pageTeacher/{current}/{limit}")
    public ApiResult pageTeacher(@ApiParam(name = "current", value = "当前页", required = true)
                                     @PathVariable long current,
                                 @ApiParam(name = "limit", value = "页面大小", required = true)
                                 @PathVariable long limit) {
        Page<EduTeacher> teacherPage = new Page<>(current, limit);
        eduTeacherService.page(teacherPage, null);
        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);

        return ApiResult.success().data(map);

    }

    @ApiOperation("条件分页查询讲师")
    @PostMapping(value = "pageTeacherCondition/{current}/{limit}")
    public ApiResult pageTeacherCondition(@ApiParam(name = "current", value = "当前页", required = true)
                                              @PathVariable long current,
                                          @ApiParam(name = "limit", value = "页面大小", required = true)
                                              @PathVariable long limit,
                                          @ApiParam(name = "teacherQuery", value = "查询条件", required = false)
                                          @RequestBody(required = false) TeacherQuery teacherQuery) {

        Page<EduTeacher> teacherPage = new Page<>(current, limit);

        QueryWrapper<EduTeacher> queryWrapper = new QueryWrapper<>();
        //调用get方法前一定要先判断是否为空，否则会报空指针
        if(null != teacherQuery.getName()) {
            String name = teacherQuery.getName();
            queryWrapper.like("name", name);
        }
        if(null != teacherQuery.getLevel()) {
            int level = teacherQuery.getLevel();
            queryWrapper.eq("level", level);
        }

        if(null != teacherQuery.getBegin()) {
            String begin = teacherQuery.getBegin();
            queryWrapper.ge("gmt_create", begin);
        }

        if(null != teacherQuery.getEnd()) {
            String end = teacherQuery.getEnd();
            queryWrapper.le("gmt_create", end);
        }
        queryWrapper.orderByDesc("gmt_create");

        eduTeacherService.page(teacherPage, queryWrapper);

        long total = teacherPage.getTotal();
        List<EduTeacher> records = teacherPage.getRecords();

        Map<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);

        return ApiResult.success().data(map);


    }

    @ApiOperation("添加讲师")
    @PostMapping("addTeacher")
    public ApiResult addTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.save(eduTeacher);
        return flag? ApiResult.success():ApiResult.error();
    }

    @ApiOperation("按照id查询讲师")
    @GetMapping("{id}")
    public ApiResult getTeacherById(@ApiParam(name = "id", value = "讲师id", required = true)
                                        @PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        return ApiResult.success().data("item",eduTeacher);
    }

    @ApiOperation("更新讲师信息")
    @PostMapping("updateTeacher")
    public ApiResult updateTeacher(@RequestBody EduTeacher eduTeacher) {
        boolean flag = eduTeacherService.updateById(eduTeacher);
        return flag? ApiResult.success():ApiResult.error();
    }

}

