package com.schoolsystem.service;

import com.schoolsystem.pojo.Student;

public interface StudentService {
    Student getInfoByUsername(String username);

    int updateStudentPhone(String phone,Integer id);
}
