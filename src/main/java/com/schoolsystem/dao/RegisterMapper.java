package com.schoolsystem.dao;

import com.schoolsystem.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import javax.print.DocFlavor;
import java.util.List;

@Mapper
public interface RegisterMapper {
    int addUser(Account account);

    @Select("select username from admin where username=#{username} union select username from student where username=#{username}")
    String selectExistAccount(Account account);
}
