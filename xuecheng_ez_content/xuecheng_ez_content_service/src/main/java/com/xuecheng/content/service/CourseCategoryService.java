package com.xuecheng.content.service;

import com.xuecheng.model.dto.CourseCategoryTreeDTO;

import java.util.List;

public interface CourseCategoryService {

    public List<CourseCategoryTreeDTO> selectTreeNodes(String id);
}
