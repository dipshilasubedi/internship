package com.example.RoutineCrudProject.service;

import com.example.RoutineCrudProject.core.payload.GlobalResponse;
import com.example.RoutineCrudProject.payload.request.ProgramRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProgramService {
    GlobalResponse createProgram(ProgramRequest programRequest);

    GlobalResponse getProgramById(Long id);

    GlobalResponse updateProgram(ProgramRequest programRequest, Long id);

    GlobalResponse deleteProgram(Long id);

    GlobalResponse getAllProgram();
}
