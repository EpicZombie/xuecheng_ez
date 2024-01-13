package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.model.dto.QueryCourseParamsDto;
import com.xuecheng.model.po.CourseBase;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseBaseMapperTests {

    @Autowired
    CourseBaseMapper courseBaseMapper;

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Test
    void testCourseBaseMapper() {

        CourseBase courseBase = courseBaseMapper.selectById(1);
//        Assertions.assertNotNull(courseBase);

        QueryCourseParamsDto courseDto = new QueryCourseParamsDto();
        courseDto.setCourseName("java");
        //拼装查询条件 构建Wrapper
        LambdaQueryWrapper<CourseBase> qWrapper = new LambdaQueryWrapper<>();
        qWrapper.like(StringUtils.isNoneEmpty(courseDto.getCourseName()),CourseBase::getName,courseDto.getCourseName());
        qWrapper.eq(StringUtils.isNotEmpty(courseDto.getAuditStatus()),CourseBase::getAuditStatus,courseDto.getAuditStatus());
        //分页参数对象
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(2L);

        //TODO 按照课程发布状态查询

        //创建page分页参数的对象 参数：当前页码，每一页记录数
        Page<CourseBase> courseBasePage = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> pageResult = courseBaseMapper.selectPage(courseBasePage,qWrapper);
        List<CourseBase> items = pageResult.getRecords();

        long total = pageResult.getTotal();
        //拿到总记录数
        PageResult<CourseBase> courseBasePageResult = new PageResult<>(items,total,pageParams.getPageNo(),pageParams.getPageSize());
        System.out.println(courseBasePageResult);
    }

}