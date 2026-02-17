package com.example.RoutineCrudProject.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProgramResponse {
    private Long id;
    private String name;
    private  String description;
}
