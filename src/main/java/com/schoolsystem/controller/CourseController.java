package com.schoolsystem.controller;

import com.schoolsystem.pojo.Course;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.CourseService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/course")
    public Result getStudentCourse(@RequestParam("studentId") Integer studentId){

        List<Course> studentCourse = courseService.getStudentCourse(studentId);
        System.out.println("获取到的课程表为：");

        for (Course course : studentCourse) {
            System.out.println(course);
        }
        return Result.success(studentCourse);
    }
}
