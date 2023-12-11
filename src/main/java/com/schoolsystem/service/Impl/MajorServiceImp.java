package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.MajorMapper;
import com.schoolsystem.service.MajorService;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImp implements MajorService {

    @Autowired
    MajorMapper majorMapper;
    @Override
    public String getName(@NotNull Integer id) {
        return majorMapper.getName(id);
    }
}
