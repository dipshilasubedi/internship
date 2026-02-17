package com.example.RoutineCrudProject.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoutineRequest {
    private String subjectName;
    private String time;
    private String teacherName;
    private String creditHour;
    private String day;
    private Long programId;
}
