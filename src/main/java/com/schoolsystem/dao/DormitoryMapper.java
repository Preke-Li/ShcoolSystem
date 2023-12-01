package com.schoolsystem.dao;

import com.schoolsystem.pojo.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DormitoryMapper {

    @Select("SELECT * FROM dormitory WHERE id = #{dormitoryId}")
    Dormitory getDormitoryById(int dormitoryId);

    @Update("UPDATE dormitory SET electricity = #{electricity} WHERE id = #{id}")
    void updateDormitory(Dormitory dormitory);

    @Update("UPDATE dormitory SET water = #{water} WHERE id = #{id}")
    void updateDormitory1(Dormitory dormitory);
}
