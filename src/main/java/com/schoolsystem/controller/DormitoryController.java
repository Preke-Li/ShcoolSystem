package com.schoolsystem.controller;

import com.schoolsystem.pojo.Dormitory;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DormitoryController {
    @Autowired
    DormitoryService dormitoryService;

    @GetMapping("/dormitory")
    public Result getDormitoryInfo(@RequestParam("id") Integer id){
        Dormitory dormitoryInfo = dormitoryService.getDormitoryInfo(id);
        return Result.success(dormitoryInfo);
    }
}
