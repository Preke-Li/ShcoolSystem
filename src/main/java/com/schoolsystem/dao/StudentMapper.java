package com.schoolsystem.dao;

import com.schoolsystem.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    @Select("select id, name, phone, major, position, class_id, username, dormitory_id from student where username=#{username}")
    Student getInfoByUsername(String username);
}
