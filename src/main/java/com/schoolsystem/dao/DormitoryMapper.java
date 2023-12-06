package com.schoolsystem.dao;

import com.schoolsystem.pojo.Dormitory;
import com.schoolsystem.pojo.DormitoryRepair;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DormitoryMapper {

    @Select("select * from dormitory where id=#{id}")
    Dormitory getDormitoryInfo(Integer id);

    @Insert("insert into repair_apply(student_id, dormitory_id, repair_type, phone, description) VALUES " +
            "(#{studentId},#{dormitoryId},#{repairType},#{phone},#{description})")
    int addRepair(DormitoryRepair dormitoryRepair);
}
