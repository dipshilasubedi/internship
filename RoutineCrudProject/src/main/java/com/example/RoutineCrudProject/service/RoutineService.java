package com.example.RoutineCrudProject.service;

import com.example.RoutineCrudProject.core.payload.GlobalResponse;
import com.example.RoutineCrudProject.payload.request.RoutineRequest;
import com.example.RoutineCrudProject.payload.response.RoutineResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RoutineService {
    GlobalResponse createRoutine(RoutineRequest routine);

    GlobalResponse getRoutineById(Long id);

    GlobalResponse deleteRoutine(Long id);

    GlobalResponse updateRoutine(RoutineRequest routine, Long id);
    GlobalResponse getRoutines();
}
