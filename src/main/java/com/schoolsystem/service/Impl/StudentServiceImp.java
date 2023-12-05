package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student getInfoByUsername(String username) {
        return studentMapper.getInfoByUsername(username);
    }
}
