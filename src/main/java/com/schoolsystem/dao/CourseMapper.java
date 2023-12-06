package com.schoolsystem.dao;

import com.schoolsystem.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CourseMapper {
    @Select("select course_id from course_list where student_id=#{studentId}")
    List<Integer> getStudentCourse(Integer studentId);

    List<Course> getCourseInfoById(List<Integer> courseIds);
}
