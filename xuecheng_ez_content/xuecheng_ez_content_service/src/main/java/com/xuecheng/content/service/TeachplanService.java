package com.xuecheng.content.service;

import com.xuecheng.model.dto.SaveTeachPlanDto;
import com.xuecheng.model.dto.TeachplanDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TeachplanService {

    public List<TeachplanDto> findTeacplanTree(Long courseId);

    public void saveTeachplan( @RequestBody SaveTeachPlanDto teachplan);
}