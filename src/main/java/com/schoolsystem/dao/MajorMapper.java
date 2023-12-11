package com.schoolsystem.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MajorMapper {
    @Select("select name from major where id=#{id}")
    String getName(Integer id);
}
