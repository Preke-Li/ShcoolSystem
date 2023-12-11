package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.CourseMapper;
import com.schoolsystem.pojo.Course;
import com.schoolsystem.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    CourseMapper courseMapper;
    @Override
    public List<Course> getStudentCourse(Integer studentId) {
        List<Integer> courseId=courseMapper.getStudentCourse(studentId);
        return courseMapper.getCourseInfoById(courseId);
    }
}
