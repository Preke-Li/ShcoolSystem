package com.schoolsystem.dao;

import com.schoolsystem.pojo.Dormitory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DormitoryMapper {

    @Select("select * from dormitory where id=#{id}")
    Dormitory getDormitoryInfo(Integer id);
}
