package com.example.RoutineCrudProject.payload.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProgramRequest {
    private String name;
    private String description;
}
