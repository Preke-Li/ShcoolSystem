package com.schoolsystem.dao;

import com.schoolsystem.pojo.Balance;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface BalanceMapper {
    @Select("SELECT * FROM daily_balance WHERE dormitory_id = #{dormitoryId}")
    List<Balance> getDailyBalances(int dormitoryId);

    @Insert("INSERT INTO daily_balance (dormitory_id, date, electricity, water) VALUES (#{dormitoryId}, #{date}, #{electricity}, #{water})")
    void insertDailyBalance(Balance balance);
}

