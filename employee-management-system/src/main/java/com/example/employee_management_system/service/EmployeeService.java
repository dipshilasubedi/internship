package com.example.employee_management_system.service;

import com.example.employee_management_system.payload.request.EmployeeRequest;
import com.example.employee_management_system.payload.response.EmployeeResponse;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employee);

    List<EmployeeResponse> getEmployees();

    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse updateEmployee(Long id, EmployeeRequest employee);

    void deleteEmployee(Long id);
}
