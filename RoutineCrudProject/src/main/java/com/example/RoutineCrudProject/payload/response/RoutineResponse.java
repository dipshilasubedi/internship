package com.example.RoutineCrudProject.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoutineResponse {
    private Long id;
    private String subjectName;
    private String time;
    private String teacherName;
    private String creditHour;
    private String day;
    private ProgramResponse program;
}
