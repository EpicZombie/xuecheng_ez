package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.service.CourseCategoryService;
import com.xuecheng.model.dto.CourseCategoryTreeDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {


    @Autowired
    CourseCategoryMapper categoryMapper;

    @Override
    public List<CourseCategoryTreeDTO> selectTreeNodes(String id) {
        List<CourseCategoryTreeDTO> courseCategoryTreeDTOList = categoryMapper.selectTreeNodes(id);
        //找到每个节点的子节点，最终找到Category
        Map<String, CourseCategoryTreeDTO> map = courseCategoryTreeDTOList.stream().filter(e ->!id.equals(e.getId())).collect(Collectors.toMap(e -> e.getId(), v -> v, (k1, k2) -> k2));
        List<CourseCategoryTreeDTO> courseCategoryList = new ArrayList<>();
        courseCategoryTreeDTOList.stream().forEach(e -> {
            //向list中写入元素
            if(e.getParentid().equals(id)){
                courseCategoryList.add(e);
            }
            //找到节点的父节点
            CourseCategoryTreeDTO courseCategoryTreeDTO = map.get(e.getParentid());
            if(courseCategoryTreeDTO != null){
                //new一个新的list来放自己的list
                if(courseCategoryTreeDTO.getChildrenTreeNodes() == null){
                    courseCategoryTreeDTO.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDTO>());
                }
                //找到每个子节点 放在 父节点的childrenTreeNodes里面
                courseCategoryTreeDTO.getChildrenTreeNodes().add(e);
            }
        });

        return courseCategoryList;
    }
}
