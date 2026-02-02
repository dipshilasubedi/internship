package com.example.student_management_system.service.impl;

import com.example.student_management_system.entity.StudentEntity;
import com.example.student_management_system.payload.request.StudentRequest;
import com.example.student_management_system.payload.response.StudentResponse;
import com.example.student_management_system.repository.StudentRepository;
import com.example.student_management_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

//    public StudentServiceImpl(StudentRepository studentRepository) {
//        this.studentRepository = studentRepository;
//    }

    @Override
    public void createStudent(StudentRequest student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setGender(student.getGender());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setCourse(student.getCourse());
        studentRepository.save(studentEntity);
    }

    @Override
    public List<StudentResponse> getStudents() {
        List<StudentResponse> studentResponseList = studentRepository.getAllStudents();
        return studentResponseList;
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        StudentEntity studentEntityOptional = studentRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, ""));
        return null;
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest student) {
        StudentEntity studentEntityOptional = studentRepository.findStudentById(id).
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setGender(student.getGender());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setCourse(student.getCourse());
        studentRepository.save(studentEntity);
        return null;
    }
    @Override
    public void deleteStudent(Long id) {
     StudentEntity studentEntityOptional = studentRepository.findStudentById(id).
             orElseThrow(()-> new RuntimeException( "Student not found"));
        studentRepository.delete(studentEntityOptional);
    }
}

