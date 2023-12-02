package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.ClassMapper;
import com.schoolsystem.pojo.Class;
import com.schoolsystem.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ClassServiceImp implements ClassService {

    @Autowired
    ClassMapper classMapper;
    @Override
    public List<Class> getByMajorId(Integer majorId) {
        return classMapper.getByMajorId(majorId);
    }

    @Override
    public int addClass(Class c) {
        return classMapper.insertClass(c);
    }

    @Override
    public int updateClass(Class c) {
        return classMapper.updateClass(c);
    }

}
