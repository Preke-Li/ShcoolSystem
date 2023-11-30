package com.schoolsystem.dao;

import com.schoolsystem.pojo.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DormitoryMapper {

    @Select("SELECT * FROM dormitory WHERE id = #{dormitory_id}")
    Dormitory getDormitoryById(int dormitory_id);

//    @Select("SELECT * FROM dormitory WHERE id = (SELECT dormitory_id FROM student WHERE id = #{studentId})")
//    Dormitory getDormitoryById(int studentId);

    @Update("UPDATE dormitory SET electricity = #{electricity} WHERE id = #{id}")
    void updateDormitory(Dormitory dormitory);
}
