package com.example.student_management_system.controller;

import com.example.student_management_system.payload.request.StudentRequest;

import com.example.student_management_system.service.StudentService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

//    public StudentController(StudentService studentService) {
//
//        this.studentService = studentService;
  //  }

    @PostMapping("/student")
//    public ResponseEntity<?> createStudent(@RequestBody StudentRequest student) {
//        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.OK);
//    }

    public void createStudent(@RequestBody StudentRequest student) {
        studentService.createStudent(student);
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody StudentRequest student) {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
