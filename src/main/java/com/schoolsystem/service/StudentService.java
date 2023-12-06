package com.schoolsystem.service;

import com.schoolsystem.pojo.Student;

public interface StudentService {
    Student getInfoByUsername(String username);

    int updateStudent(String phone,String username,String avatar);

    int addStudent(Student student);
}
