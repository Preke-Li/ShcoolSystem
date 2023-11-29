package com.schoolsystem.dao;


import com.schoolsystem.pojo.Class;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClassMapper {
    /**
     * 查询某个专业的所有班级信息
     * @param majorId
     * @return
     */
    @Select("select * from class where major_id=#{majorId}")
    List<Class> getByMajorId(Integer majorId);


    @Insert("insert into class(class_name, people, monitor_id, major_id) VALUES (#{className},#{people},#{monitorId},#{majorId})")
    int insertClass(Class c);
}
