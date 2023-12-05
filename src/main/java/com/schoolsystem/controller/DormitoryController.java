package com.schoolsystem.controller;

import com.schoolsystem.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DormitoryController {
    @Autowired
    DormitoryService dormitoryService;
}
