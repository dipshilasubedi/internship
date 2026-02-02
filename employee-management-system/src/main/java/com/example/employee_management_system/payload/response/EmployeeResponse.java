package com.example.employee_management_system.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeResponse {
    public EmployeeResponse(Long id, String name, String age, String gender, String email, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.department = department;
    }

    private Long id;
    private String name;
    private String age;
    private String gender;
    private String email;
    private String department;

}
