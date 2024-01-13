package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.model.dto.CourseCategoryTreeDTO;
import com.xuecheng.model.dto.QueryCourseParamsDto;
import com.xuecheng.model.po.CourseBase;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseCategoryMapperTests {


    @Autowired
    CourseCategoryMapper courseCategoryMapper;

    @Test
    void testCourseBaseMapper() {
        List<CourseCategoryTreeDTO> courseCategoryMapperList = courseCategoryMapper.selectTreeNodes("1");
        System.out.println(courseCategoryMapperList);
    }

}