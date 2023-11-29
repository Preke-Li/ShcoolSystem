package com.schoolsystem.dao;

import com.schoolsystem.pojo.Account;
import com.schoolsystem.pojo.Admin;
import com.schoolsystem.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    @Select("select * from student where username=#{username} and password=#{password}")
    Student studentLogin(Account account);

    @Select("select * from admin where username=#{username} and password=#{password}")
    Admin adminLogin(Account account);
}
