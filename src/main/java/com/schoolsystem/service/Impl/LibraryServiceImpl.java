package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.LibraryMapper; // 假设有一个LibraryMapper来处理数据库操作
import com.schoolsystem.pojo.BookTransaction;
import com.schoolsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryMapper libraryMapper; // 需要创建一个 LibraryMapper 接口来处理数据库操作

    @Override
    public List<BookTransaction> getLibraryTransactions(int studentId) {
        // 实现查询图书借阅记录的业务逻辑，调用 LibraryMapper 进行数据库操作
        return libraryMapper.getLibraryTransactions(studentId);
    }

    @Override
    public void borrowBook(int studentId, int bookId) {
        // 实现图书借阅申请的业务逻辑，调用 LibraryMapper 进行数据库操作
        libraryMapper.borrowBook(studentId, bookId);
    }
}
