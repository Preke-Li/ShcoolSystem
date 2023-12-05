package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.DormitoryMapper;
import com.schoolsystem.pojo.Dormitory;
import com.schoolsystem.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DormitoryServiceImp implements DormitoryService {
    @Autowired
    DormitoryMapper dormitoryMapper;

    @Override
    public Dormitory getDormitoryInfo(Integer id) {
        return dormitoryMapper.getDormitoryInfo(id);
    }
}
