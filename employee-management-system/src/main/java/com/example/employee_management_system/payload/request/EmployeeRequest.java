package com.example.employee_management_system.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeRequest {
    private String name;
    private String age;
    private String gender;
    private String email;
    private String department;
}

