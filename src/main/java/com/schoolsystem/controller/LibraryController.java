package com.schoolsystem.controller;

import com.schoolsystem.pojo.Result;
import com.schoolsystem.pojo.BookTransaction;
import com.schoolsystem.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    // 6.1 查询图书借阅记录
    @PostMapping("/library/transactions")
    public Result getLibraryTransactions(@RequestBody Map<String, String> requestData) {
        try {
            int studentId = Integer.parseInt(requestData.get("studentId"));
            String startDate = requestData.get("startDate");
            String endDate = requestData.get("endDate");
            // 调用 Service 层方法获取图书借阅记录
            List<BookTransaction> transactions = libraryService.getLibraryTransactions(studentId, startDate, endDate);
            return Result.success(transactions);
        } catch (Exception e) {
            return Result.error("查询图书借阅记录失败：" + e.getMessage());
        }
    }

    // 6.2 图书借阅申请
    @PostMapping("/library/borrow")
    public Result borrowBook(@RequestBody Map<String, Integer> requestData) {
        try {
            int studentId = requestData.get("studentId");
            int bookId = requestData.get("bookId");

            // 调用 Service 层方法进行图书借阅申请
            libraryService.borrowBook(studentId, bookId);

            return Result.success("图书借阅申请成功");
        } catch (Exception e) {
            return Result.error("图书借阅申请失败：" + e.getMessage());
        }
    }
}
