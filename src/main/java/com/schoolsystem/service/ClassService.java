package com.schoolsystem.service;

import com.schoolsystem.pojo.Class;

import java.util.List;


public interface ClassService {
    List<Class> getByMajorId(Integer majorId);

    int addClass(Class c);

    int updateClass(Class c);
}
