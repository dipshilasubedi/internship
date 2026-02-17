package com.example.RoutineCrudProject.service.impl;

import com.example.RoutineCrudProject.core.payload.GlobalResponse;
import com.example.RoutineCrudProject.core.payload.GlobalResponseBuilder;
import com.example.RoutineCrudProject.entity.ProgramEntity;
import com.example.RoutineCrudProject.exception.ResourceNotFoundException;
import com.example.RoutineCrudProject.mapper.ProgramMapper;
import com.example.RoutineCrudProject.payload.request.ProgramRequest;
import com.example.RoutineCrudProject.payload.response.ProgramResponse;
import com.example.RoutineCrudProject.repository.ProgramRepository;
import com.example.RoutineCrudProject.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProgramServiceImpl implements ProgramService {
    private final ModelMapper modelMapper;
    private final ProgramRepository programRepository;

    @Override
    public GlobalResponse createProgram(ProgramRequest programRequest) {
        ProgramEntity programEntity = modelMapper.map(programRequest, ProgramEntity.class);
        programRepository.save(programEntity);
        return GlobalResponseBuilder.buildSucessResponse("Program is created");
    }

    @Override
    public GlobalResponse getProgramById(Long id) {
        ProgramEntity programEntity = programRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Program not found."));
        ProgramResponse programResponse = modelMapper.map(programEntity, ProgramResponse.class);
        return GlobalResponseBuilder.buildSucessResponseWithData("Program fetch successfully", programResponse);
    }

    @Override
    public GlobalResponse updateProgram(ProgramRequest programRequest, Long id) {
        ProgramEntity programEntity = programRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Progra not found"));
        ProgramEntity programEntity1 = ProgramMapper.INSTANCE.toUpdate(programRequest, programEntity);
        programRepository.save(programEntity1);
        return GlobalResponseBuilder.buildSucessResponse("Program updated.");
    }

    @Override
    public GlobalResponse deleteProgram(Long id) {
        ProgramEntity programEntity = programRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Program not found"));
        programRepository.delete(programEntity);
        return GlobalResponseBuilder.buildSucessResponse("Program Deleted");
    }

    @Override
    public GlobalResponse getAllProgram() {
        List<ProgramEntity> programEntityList = programRepository.findAll();
        List<ProgramResponse> programResponseList = programEntityList.stream()
                .map(program -> modelMapper.map(program, ProgramResponse.class))
                .collect(Collectors.toList());
        return GlobalResponseBuilder.buildSucessResponseWithData("All program fetched", programResponseList);

    }
}
