package com.example.RoutineCrudProject.service.impl;

import com.example.RoutineCrudProject.core.payload.GlobalResponse;
import com.example.RoutineCrudProject.core.payload.GlobalResponseBuilder;
import com.example.RoutineCrudProject.entity.ProgramEntity;
import com.example.RoutineCrudProject.mapper.RoutineMapper;
import com.example.RoutineCrudProject.entity.RoutineEntity;
import com.example.RoutineCrudProject.exception.ResourceNotFoundException;
import com.example.RoutineCrudProject.payload.request.RoutineRequest;
import com.example.RoutineCrudProject.payload.response.ProgramResponse;
import com.example.RoutineCrudProject.payload.response.RoutineResponse;
import com.example.RoutineCrudProject.repository.ProgramRepository;
import com.example.RoutineCrudProject.repository.RoutineRepository;
import com.example.RoutineCrudProject.service.RoutineService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoutineServiceImpl implements RoutineService {
    private final RoutineRepository routineRepository;
    private final ModelMapper modelMapper;
    private final ProgramRepository programRepository;

    @Override
    public GlobalResponse createRoutine(RoutineRequest routine) {
//        RoutineEntity routineEntity= modelMapper.map(routine, RoutineEntity.class);

        //user le request ma pathauxa but thats not a format of database (entity)ho
        // yo convert garne xae ModelMapper (method) le garxa aani jun aako data lae
        // entity ma convert gardinxa aani feri back output dinxa
        //=aagi xae kun format ma lagne (enitity) format ma
        // RoutineEntity routineEntity = ModelMapper.INSTANCE.toEntity(routine);
        RoutineEntity routineEntity = modelMapper.map(routine, RoutineEntity.class);
        ProgramEntity programEntity = programRepository.findById(routine.getProgramId()).
                orElseThrow(() -> new ResourceNotFoundException("Program not found."));
        routineEntity.setProgram(programEntity);
        routineRepository.save(routineEntity);
        return GlobalResponseBuilder.buildSucessResponse("Routine created");
    }

    @Override
    public GlobalResponse getRoutineById(Long id) {
        RoutineEntity routineEntity = routineRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Routine not found."));
        //RoutineResponse routineResponse =ModelMapper.INSTANCE.toResponse(routineEntity);
        RoutineResponse routineResponse = modelMapper.map(routineEntity, RoutineResponse.class);
        if (routineEntity.getProgram() != null) {
            ProgramResponse programResponse = modelMapper.map(routineEntity.getProgram(), ProgramResponse.class);
            routineResponse.setProgram(programResponse);
        }
        return GlobalResponseBuilder.buildSucessResponseWithData("data fetch Successfully", routineResponse);
    }

    @Override
    public GlobalResponse deleteRoutine(Long id) {
        RoutineEntity routineEntity = routineRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Routine not found."));
        routineRepository.delete(routineEntity);
        return GlobalResponseBuilder.buildSucessResponse("Routine is deleted Successfully");
    }

    @Override
    public GlobalResponse updateRoutine(RoutineRequest routine, Long id) {
        RoutineEntity routineEntity = routineRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Routine Not found."));
        RoutineEntity routineEntity1 = RoutineMapper.INSTANCE.toUpdate(routine, routineEntity);
        routineRepository.save(routineEntity1);
        return GlobalResponseBuilder.buildSucessResponse("Routine updated successfully");
    }

    @Override
    public GlobalResponse getRoutines() {
        List<RoutineEntity> routineEntityList = routineRepository.findAll();
        //stream use gare pani  List <RoutineEntity> stream ma convert hunxa
        // aani data break garna milxa
//        List<RoutineResponse> routineResponseList = routineEntityList.stream()
//                //acts like a loop picks each data from streams and perform there opertaion which is
//                // written after arrow each data is stored in variable which is written before arrow
//                .map(routine -> modelMapper.map(routine, RoutineResponse.class))
//                //yesle xae mathi convert vako each data lae feri list ma collect garxa
//                //individual ,stream data dina mildaena so feri list ma collect gaera dine
//                .collect(Collectors.toList());
        List<RoutineResponse> routineResponseList = routineEntityList.stream()
                .map(routine -> {
                    RoutineResponse routineResponse = modelMapper.map(routine, RoutineResponse.class);
                    if (routine.getProgram() != null) {
                        ProgramResponse programResponse = modelMapper.map(routine.getProgram(), ProgramResponse.class);
                        routineResponse.setProgram(programResponse);
                    }
                    return routineResponse;
                }).toList();

        return GlobalResponseBuilder.buildSucessResponseWithData("data fetch successfully", routineResponseList);

    }
}

