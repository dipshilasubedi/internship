package com.example.RoutineCrudProject.mapper;

import com.example.RoutineCrudProject.entity.RoutineEntity;
import com.example.RoutineCrudProject.payload.request.RoutineRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;



//Model mapper ma
//Database bata aako data. lae xae response ma ra request lai database ko format ma convert garxa
// extra part aayo vane request bata ignore garxa code ko flow nabigari kina
//Converting Request → Entity
//Converting Entity → Response
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoutineMapper {
//    public static RoutineEntity toEntity(RoutineRequest routine){
//        RoutineEntity routineEntity=new RoutineEntity();
//        routineEntity.setSubjectname(routine.getSubjectname());
//        routineEntity.setTime(routine.getTime());
//        routineEntity.setTeachername(routine.getTeachername());
//        routineEntity.setCredithour(routine.getCredithour());
//        routineEntity.setDay(routine.getDay());
//        return routineEntity;
//    }
//    public static RoutineResponse toResponse(RoutineEntity routineEntity){
//        RoutineResponse routineResponse=new RoutineResponse();
//        routineResponse.setId(routineEntity.getId());
//        routineResponse.setSubjectname(routineEntity.getSubjectname());
//        routineResponse.setTime(routineEntity.getTime());
//        routineResponse.setTeachername(routineEntity.getTeachername());
//        routineResponse.setCredithour(routineEntity.getCredithour());
//        routineResponse.setDay(routineEntity.getDay());
//        return routineResponse;
//    }


    //Ele chai impl class banai dinxa like
//Tyo method haru hunxa ni  toResponse bala ani tesko body ma vako code auto matically banauxa
    RoutineMapper INSTANCE = Mappers.getMapper(RoutineMapper.class);

//    RoutineEntity toEntity(RoutineRequest routine);
//
//    RoutineResponse toResponse(RoutineEntity routineEntity);
//
//    List<RoutineResponse> toResponseList(List<RoutineEntity> routineEntity);


//    public static RoutineEntity toUpdate(RoutineRequest routine, RoutineEntity routineEntity){
//        routineEntity.setSubjectname(routine.getSubjectname());
//        routineEntity.setTime(routine.getTime());
//        routineEntity.setTeachername(routine.getTeachername());
//        routineEntity.setCredithour(routine.getCredithour());
//        routineEntity.setDay(routine.getDay());
//        return routineEntity;
//    }

    RoutineEntity toUpdate(RoutineRequest routine, @MappingTarget RoutineEntity routineEntity);
}
