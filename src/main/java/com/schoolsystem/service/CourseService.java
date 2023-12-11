package com.schoolsystem.service;

import com.schoolsystem.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course> getStudentCourse(Integer studentId);

}
