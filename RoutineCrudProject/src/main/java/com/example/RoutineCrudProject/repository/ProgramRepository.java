package com.example.RoutineCrudProject.repository;

import com.example.RoutineCrudProject.entity.ProgramEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<ProgramEntity,Long> {
}
