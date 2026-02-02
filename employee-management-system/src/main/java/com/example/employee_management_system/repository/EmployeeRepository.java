package com.example.employee_management_system.repository;

import com.example.employee_management_system.entity.EmployeeEntity;
import com.example.employee_management_system.payload.response.EmployeeResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query("SELECT new com.example.employee_management_system.payload.response.EmployeeResponse(e.id,e.name,e.age,e.gender,e.email,e.department) " + "FROM EmployeeEntity e")
    List<EmployeeResponse> getAllEmployees();

//    @Query("SELECT new com.example.employee_management_system.payload.response.EmployeeResponse(e.id,e.name,e.age,e.gender,e.email,e.department) " + "FROM EmployeeEntity e WHERE e.id = :id")
    Optional<EmployeeResponse> getEmployeeById(Long id);


    Optional<EmployeeEntity> findEmployeeById(Long id);
}
