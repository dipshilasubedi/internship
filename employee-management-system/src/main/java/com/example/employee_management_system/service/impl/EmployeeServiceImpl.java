package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.entity.EmployeeEntity;
import com.example.employee_management_system.payload.request.EmployeeRequest;
import com.example.employee_management_system.payload.response.EmployeeResponse;
import com.example.employee_management_system.repository.EmployeeRepository;
import com.example.employee_management_system.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest student) {

        EmployeeEntity studentEntity = new EmployeeEntity();
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setGender(student.getGender());
        studentEntity.setEmail(student.getEmail());
        studentEntity.setDepartment(student.getDepartment());
        employeeRepository.save(studentEntity);
//        EmployeeResponse employeeResponse = new EmployeeResponse();
//        employeeResponse.setId(studentEntity.getId());
//        employeeResponse.setName(studentEntity.getName());
//        employeeResponse.setAge(studentEntity.getAge());
//        employeeResponse.setGender(studentEntity.getGender());
//        employeeResponse.setEmail(studentEntity.getEmail());
//        employeeResponse.setDepartment(studentEntity.getDepartment());
//        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> getEmployees() {
        List<EmployeeResponse> employeeResponseList = employeeRepository.getAllEmployees();
        return employeeResponseList;
    }

    @Override
    public EmployeeResponse getEmployeeById(Long id) {
       EmployeeEntity employeeResponseOptional = employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,""));
        return null;
    }

    @Override
    public EmployeeResponse updateEmployee(Long id, EmployeeRequest employee) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findEmployeeById(id);
        if (employeeEntityOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        EmployeeEntity employeeEntity = employeeEntityOptional.get();
        employeeEntity.setName(employee.getName());
        employeeEntity.setAge(employee.getAge());
        employeeEntity.setGender(employee.getGender());
        employeeEntity.setEmail(employee.getEmail());
        employeeEntity.setDepartment(employee.getDepartment());
        employeeRepository.save(employeeEntity);

//        EmployeeResponse employeeResponse = new EmployeeResponse();
//        employeeResponse.setId(employeeEntity.getId());
//        employeeResponse.setName(employeeEntity.getName());
//        employeeResponse.setAge(employeeEntity.getAge());
//        employeeResponse.setGender(employeeEntity.getGender());
//        employeeResponse.setEmail(employeeEntity.getEmail());
//        employeeResponse.setDepartment(employeeEntity.getDepartment());
//        return employeeResponse;
}

    @Override
    public void deleteEmployee(Long id) {
        Optional<EmployeeEntity> employeeEntityOptional = employeeRepository.findEmployeeById(id);
        if (employeeEntityOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
        EmployeeEntity employeeEntity = employeeEntityOptional.get();
        employeeRepository.delete(employeeEntity);
    }
}
