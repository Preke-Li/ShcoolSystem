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

    // 可能还需要其他的查询、插入、更新方法
}
