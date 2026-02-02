package com.example.student_management_system.repository;

import com.example.student_management_system.entity.StudentEntity;
import com.example.student_management_system.payload.response.StudentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    @Query("SELECT new com.example.student_management_system.payload.response.StudentResponse(s.id,s.name,s.age,s.gender,s.email,s.course) " + "FROM StudentEntity s")
    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long id);

    Optional<StudentEntity> findStudentById(Long id);
}
