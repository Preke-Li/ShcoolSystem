package com.schoolsystem.service;

import java.util.List;
import com.schoolsystem.pojo.BookTransaction;

public interface LibraryService {

    // 查询图书借阅记录
    List<BookTransaction> getLibraryTransactions(int studentId);

    // 图书借阅申请
    void borrowBook(int studentId, int bookId);
}
