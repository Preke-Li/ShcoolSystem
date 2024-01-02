package com.schoolsystem.dao;

import com.schoolsystem.pojo.BookTransaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LibraryMapper {

    @Select("SELECT * FROM book_transaction WHERE student_id = #{studentId}")
    List<BookTransaction> getLibraryTransactions(int studentId);

    @Insert("INSERT INTO book_transaction (student_id, book_id) VALUES (#{studentId}, #{bookId})")
    void borrowBook(int studentId, int bookId);
}
