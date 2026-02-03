package com.example.student_management_system.mapper;

import com.example.student_management_system.entity.StudentEntity;
import com.example.student_management_system.payload.request.StudentRequest;
import com.example.student_management_system.payload.response.StudentResponse;

public class StudentMapper {
    public static StudentEntity toEntity(StudentRequest student){
        StudentEntity studentEntity=new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setGender(student.getGender());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setCourse(student.getCourse());
        return studentEntity;
    }
    public static StudentResponse toResponse(StudentEntity entity){
        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setName(entity.getName());
        studentResponse.setAge(entity.getAge());
        studentResponse.setGender(entity.getGender());
        studentResponse.setEmail(entity.getEmail());
        studentResponse.setCourse(entity.getCourse());
        return studentResponse;
    }
}
