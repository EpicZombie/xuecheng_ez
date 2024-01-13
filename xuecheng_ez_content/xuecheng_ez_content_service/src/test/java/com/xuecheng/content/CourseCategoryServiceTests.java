package com.xuecheng.content;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.content.service.CourseCategoryService;
import com.xuecheng.model.dto.CourseCategoryTreeDTO;
import com.xuecheng.model.dto.QueryCourseParamsDto;
import com.xuecheng.model.po.CourseBase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseCategoryServiceTests {


    @Autowired
    CourseBaseInfoService courseBaseInfoService;

    @Autowired
    CourseCategoryService courseCategoryService;

    @Test
    public void testCourseBaseInfoService(){
        //查询条件
        QueryCourseParamsDto courseParamsDto = new QueryCourseParamsDto();
        courseParamsDto.setCourseName("java");
        courseParamsDto.setAuditStatus("202004");

        PageParams pageParams = new PageParams();
        pageParams.setPageNo(2L);

//        PageResult<CourseBase> courseBasePageResult = courseBaseInfoService.queryCourseBaseList("1");

    }

    @Test
    public void testCourseCategoryService(){
        List<CourseCategoryTreeDTO> courseCategoryTreeDTOS = courseCategoryService.selectTreeNodes("1");
        System.out.println(courseCategoryTreeDTOS);
    }


}
