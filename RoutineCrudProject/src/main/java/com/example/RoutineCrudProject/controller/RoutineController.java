package com.example.RoutineCrudProject.controller;

import com.example.RoutineCrudProject.core.payload.GlobalResponse;
import com.example.RoutineCrudProject.payload.request.RoutineRequest;
import com.example.RoutineCrudProject.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/routine")
@RequiredArgsConstructor
public class RoutineController {
    private final RoutineService routineService;

    @PostMapping("/create")

    public GlobalResponse createRoutine(@RequestBody RoutineRequest routine) {
        return routineService.createRoutine(routine);
    }

    @GetMapping("/{id}")
    public GlobalResponse getRoutineById(@PathVariable Long id) {
        return routineService.getRoutineById(id);
    }

    @DeleteMapping("/{id}")
    public GlobalResponse deleteRoutine(@PathVariable Long id) {
        return routineService.deleteRoutine(id);
    }

    @PutMapping("/routine/{id}")
    public GlobalResponse updateRoutine(@RequestBody RoutineRequest routine, @PathVariable Long id) {
        return routineService.updateRoutine(routine, id);
    }

    @GetMapping("/get-routine")
    public GlobalResponse getRoutines() {
        return routineService.getRoutines();

    }

}
