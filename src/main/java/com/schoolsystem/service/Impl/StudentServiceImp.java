package com.schoolsystem.service.Impl;

import com.schoolsystem.dao.ClassMapper;
import com.schoolsystem.dao.StudentMapper;
import com.schoolsystem.pojo.Class;
import com.schoolsystem.pojo.Student;
import com.schoolsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {


    @Autowired
    StudentMapper studentMapper;
    @Autowired
    ClassMapper classMapper;
    @Override
    public Student getInfoByUsername(String username) {
        return studentMapper.getInfoByUsername(username);
    }

    @Override
    public int updateStudent(String phone,String username,String avatar) {
        return studentMapper.updateStudent(phone,username,avatar);
    }

    @Override
    public int addStudent(Student student) {
        int result=studentMapper.addStudent(student);
        if (result>0){
            //获取原来班级的人数数据
            Class classInfo=classMapper.getByClassId(student.getClassId());
            Integer people=classInfo.getPeople()+1;
            //更新班级人数
            Class c=new Class();
            c.setId(student.getClassId());
            c.setPeople(people);
            classMapper.updateClass(c);
        }
        return result;
    }
}
