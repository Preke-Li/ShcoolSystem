package com.schoolsystem.dao;

import com.schoolsystem.pojo.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CardMapper {

    @Select("SELECT * FROM card WHERE id = #{id}")
    Card getCardById(int id);

    @Update("UPDATE card SET balance = #{balance} WHERE id = #{id}")
    void updateCard(Card card);


}
