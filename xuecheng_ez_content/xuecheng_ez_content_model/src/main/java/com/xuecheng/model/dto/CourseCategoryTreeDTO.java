package com.xuecheng.model.dto;

import com.xuecheng.model.po.CourseCategory;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;


/**
 * 课程分类相关接口
 */
@Data
@ToString
public class CourseCategoryTreeDTO extends CourseCategory implements Serializable {
    List<CourseCategoryTreeDTO> childrenTreeNodes;

}
