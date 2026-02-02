package com.example.student_management_system.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentResponse {
//    public StudentResponse(Long id, String name, String age, String gender, String email, String course) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.gender = gender;
//        this.email = email;
//        this.course = course;
   // }

    private Long id;
    private String name;
    private String age;
    private String gender;
    private String email;
    private String course;

}

