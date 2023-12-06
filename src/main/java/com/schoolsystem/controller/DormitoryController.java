package com.schoolsystem.controller;

import com.schoolsystem.pojo.DormitoryRepair;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DormitoryController {
    @Autowired
    DormitoryService dormitoryService;

    @PostMapping("/dormitoryRepair")
    public Result commitRepair(@RequestBody DormitoryRepair dormitoryRepair) {
        if (dormitoryService.addRepair(dormitoryRepair)>0)
            return Result.success("提交保修成功");
        else
            return Result.error("保修失败");
    }
}
