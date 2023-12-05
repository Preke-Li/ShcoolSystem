package com.schoolsystem.dao;

import com.schoolsystem.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    @Select("select id, name, phone, major_id, position, class_id, username, dormitory_id from student where username=#{username}")
    Student getInfoByUsername(String username);

    @Update("update student set phone=#{phone} where id =#{id}")
    int updateStudentPhone(String phone,Integer id);
}
