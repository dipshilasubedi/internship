package com.example.student_management_system.controller;

import com.example.student_management_system.payload.request.StudentRequest;

import com.example.student_management_system.payload.response.StudentResponse;
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

    @PostMapping("/student")
    public void createStudent(@RequestBody StudentRequest student) {

        studentService.createStudent(student);
    }

    @GetMapping("/student")
    public ResponseEntity<?> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

  @PutMapping("/student/{id}")
  public StudentResponse updateStudent  (@PathVariable Long id, @RequestBody StudentRequest student) {
        return studentService.updateStudent(id, student);
    }

  @DeleteMapping("/student/{id}")
   public void deleteStudent(@PathVariable Long id) {
       studentService.deleteStudent(id);
    }
}
