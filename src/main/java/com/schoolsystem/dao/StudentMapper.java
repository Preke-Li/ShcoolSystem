package com.schoolsystem.dao;

import com.schoolsystem.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getStudentById(int id);

    // 可能还需要其他的查询、插入、更新方法
}
