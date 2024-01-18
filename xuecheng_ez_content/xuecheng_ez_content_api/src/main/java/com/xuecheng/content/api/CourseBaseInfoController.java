package com.xuecheng.content.api;


import com.xuecheng.base.exception.ValidationGroups;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.model.dto.AddCourseDto;
import com.xuecheng.model.dto.CourseBaseInfoDto;
import com.xuecheng.model.dto.EditCourseDto;
import com.xuecheng.model.dto.QueryCourseParamsDto;
import com.xuecheng.model.po.CourseBase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @description 课程信息编辑接口
 * @author Mr.M
 * @date 2022/9/6 11:29
 * @version 1.0
 */
@Api(value = "课程信息管理接口",tags="课程信息管理接口")
@RestController  //Controller+responseBody
public class CourseBaseInfoController {


     @Autowired
     CourseBaseInfoService courseBaseInfoService;
     @ApiOperation("课程查询接口")
     @PostMapping("/course/list")
      public PageResult<CourseBase> list( PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParams){
        PageResult<CourseBase> pageResult = courseBaseInfoService.queryCourseBaseList(pageParams,queryCourseParams);
        return pageResult;
      }

      @ApiOperation("课程新增接口")
      @PostMapping("/course/create")
      public CourseBaseInfoDto createCourseBase(@RequestBody @Validated(ValidationGroups.Insert.class) AddCourseDto addCourseDto){
          //机构id，由于认证系统没有上线暂时硬编码
          Long companyId = 1232141425L;
          return courseBaseInfoService.createCourseBase(companyId,addCourseDto);
      }

      @ApiOperation("课程id查询接口")
      @GetMapping("/course/{courseId}")
      public CourseBaseInfoDto getCourseBase(@PathVariable Long courseId){
         CourseBaseInfoDto courseBaseInfoDto = courseBaseInfoService.getCourseBaseInfo(courseId);
         return courseBaseInfoDto;
      }

    @ApiOperation("修改课程基础信息")
    @PutMapping("/course")
    public CourseBaseInfoDto modifyCourseBase(@RequestBody @Validated(ValidationGroups.update.class) EditCourseDto editCourseDto){
         Long companyId = 1232141425L;
        CourseBaseInfoDto courseBaseInfoDto = courseBaseInfoService.updateCourseBase(companyId, editCourseDto);
        return courseBaseInfoDto;
    }






}