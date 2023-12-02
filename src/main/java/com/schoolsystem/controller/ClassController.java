package com.schoolsystem.controller;

import com.schoolsystem.pojo.Class;
import com.schoolsystem.pojo.Result;
import com.schoolsystem.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ClassController {
    @Autowired
    ClassService classService;

    @GetMapping("/class")
    public Result getClassByMajorId(@RequestParam Integer id) {

        log.info("\n传入的专业Id为{}：", id);
        List<Class> list = classService.getByMajorId(id);
        log.info("\n查询到的班级信息为：{}\n", list);
        if (!list.isEmpty()) {
            return Result.success(list);
        } else {
            return Result.error("查询失败");
        }
    }

    @PostMapping("/class")
    public Result addClass(@RequestBody Class c) {
        log.info("\n接收到的新增班级数据为：\n{}", c);
        int result = classService.addClass(c);
        if (result > 0)
            return Result.success();
        else
            return Result.error("新增失败");
    }

    @PutMapping("class")
    public Result updateClass(@RequestBody Class c) {
        log.info("\n要修改的部门信息为：{}", c);
        int result = classService.updateClass(c);
        if (result > 0)
            return Result.success("更新成功");
        else
            return Result.error("更新失败");
    }

}
