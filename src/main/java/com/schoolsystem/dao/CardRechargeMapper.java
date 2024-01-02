package com.schoolsystem.dao;

import com.schoolsystem.pojo.CardRecharge;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CardRechargeMapper {


    @Insert("INSERT INTO card_recharge (student_id, money) VALUES (#{studentId}, #{money})")
    void insertCardRecharge(CardRecharge cardRecharge);


    @Select("SELECT * FROM card_recharge WHERE student_id = #{studentId}")
    List<CardRecharge> getCardTransactions(int studentId);
}
