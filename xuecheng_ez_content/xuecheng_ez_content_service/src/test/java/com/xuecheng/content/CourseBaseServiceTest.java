package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.model.dto.QueryCourseParamsDto;
import com.xuecheng.model.po.CourseBase;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CourseBaseServiceTest {

    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Test
    public void testInfoService(){

//        Assertions.assertNotNull(courseBase);

        QueryCourseParamsDto courseDto = new QueryCourseParamsDto();
        courseDto.setCourseName("java");
        courseDto.setAuditStatus("202004");
        //拼装查询条件 构建Wrapper
        LambdaQueryWrapper<CourseBase> qWrapper = new LambdaQueryWrapper<>();
        qWrapper.like(StringUtils.isNoneEmpty(courseDto.getCourseName()),CourseBase::getName,courseDto.getCourseName());
        qWrapper.eq(StringUtils.isNotEmpty(courseDto.getAuditStatus()),CourseBase::getAuditStatus,courseDto.getAuditStatus());
        //分页参数对象
        PageParams pageParams = new PageParams();
        pageParams.setPageNo(1L);
        pageParams.setPageSize(2L);
        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList(pageParams, courseDto);
        System.out.println(courseBasePageResult);
    }

}
