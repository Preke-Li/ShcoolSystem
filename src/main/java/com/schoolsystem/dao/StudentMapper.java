package com.schoolsystem.dao;

import com.schoolsystem.pojo.Student;
import com.schoolsystem.pojo.StudentBaseInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    @Select("select id, name, sex,phone, major_id, position, class_id, username, dormitory_id,avatar from student where username=#{username}")
    Student getInfoByUsername(String username);


    int updateStudent(String phone,String username,String avatar);

    @Insert("insert into student(name, sex,major_id, class_id, username, password, dormitory_id) values (#{name}, #{sex},#{majorId}, #{classId}, #{username},#{password},#{dormitoryId})")
    int addStudent(Student student);

    @Select("select id,username,name,sex from student where class_id=#{classId}")
    List<StudentBaseInfo> getStudentByClassId(Integer id);

    @Select("select * from student where id=#{id}")
    Student getInfoById(Integer id);
}
