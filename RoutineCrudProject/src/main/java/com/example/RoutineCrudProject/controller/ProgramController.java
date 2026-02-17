package com.example.RoutineCrudProject.controller;

import com.example.RoutineCrudProject.core.payload.GlobalResponse;
import com.example.RoutineCrudProject.payload.request.ProgramRequest;
import com.example.RoutineCrudProject.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/program")
@RequiredArgsConstructor
public class ProgramController {
    private final ProgramService programService;

    @PostMapping("/create")
    public GlobalResponse createProgram(@RequestBody ProgramRequest programRequest) {
        return programService.createProgram(programRequest);
    }

    @GetMapping("/{id}")
    public GlobalResponse getProgramById(@PathVariable Long id) {
        return programService.getProgramById(id);
    }

    @PutMapping("/{id}")
    public GlobalResponse updateProgram(@RequestBody ProgramRequest programRequest,@PathVariable Long id){
        return programService.updateProgram(programRequest, id);
    }

   @DeleteMapping("/{id}")
   public GlobalResponse deleteProgram(@PathVariable Long id){
        return programService.deleteProgram(id);
   }
   @GetMapping("/get-all-program")
    public GlobalResponse getAllProgram(){
        return programService.getAllProgram();
   }
}
