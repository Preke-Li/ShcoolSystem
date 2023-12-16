package com.schoolsystem.dao;

import com.schoolsystem.pojo.Dormitory;
import com.schoolsystem.pojo.DormitoryRepair;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DormitoryMapper {

    @Select("SELECT * FROM dormitory WHERE id = #{dormitoryId}")
    Dormitory getDormitoryById(int dormitoryId);

    @Update("UPDATE dormitory SET electricity = #{electricity} WHERE id = #{id}")
    void updateDormitory(Dormitory dormitory);

    @Update("UPDATE dormitory SET water = #{water} WHERE id = #{id}")
    void updateDormitory1(Dormitory dormitory);

    @Insert("insert into repair_apply(student_id, dormitory_id, repair_type, phone, description) VALUES (#{studentId},#{dormitoryId},#{repairType},#{phone},#{description})")
    int addRepair(DormitoryRepair dormitoryRepair);

    @Select("select * from dormitory")
    List<Dormitory> selectAllDormitory();
}
