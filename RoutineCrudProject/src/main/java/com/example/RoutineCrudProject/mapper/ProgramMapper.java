package com.example.RoutineCrudProject.mapper;

import com.example.RoutineCrudProject.entity.ProgramEntity;
import com.example.RoutineCrudProject.payload.request.ProgramRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE) //null aayo vane ignore gardinxa
public interface ProgramMapper {
ProgramMapper INSTANCE= Mappers.getMapper(ProgramMapper.class);
ProgramEntity  toUpdate(ProgramRequest programRequest, @MappingTarget ProgramEntity programEntity);
}
