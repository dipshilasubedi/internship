package com.example.student_management_system.service;

import com.example.student_management_system.payload.request.StudentRequest;
import com.example.student_management_system.payload.response.StudentResponse;

import java.util.List;

public interface StudentService {
    void createStudent(StudentRequest student);

    List<StudentResponse> getStudents();

    StudentResponse getStudentById(Long id);

    StudentResponse updateStudent(Long id, StudentRequest student);

    void deleteStudent(Long id);
}
