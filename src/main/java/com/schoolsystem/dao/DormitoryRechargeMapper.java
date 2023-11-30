package com.schoolsystem.dao;

import com.schoolsystem.pojo.DormitoryRecharge;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DormitoryRechargeMapper {

    @Insert("INSERT INTO dormitory_recharge (dormitory_id, amount, date, student_id) " +
            "VALUES (#{dormitoryId}, #{amount}, #{date}, #{studentId})")
    void insertDormitoryRecharge(DormitoryRecharge dormitoryRecharge);


    @Select("SELECT * FROM dormitory_recharge WHERE dormitory_id = #{dormitoryId}")
    List<DormitoryRecharge> getRechargeHistoryByDormitoryId(int dormitoryId);
}
