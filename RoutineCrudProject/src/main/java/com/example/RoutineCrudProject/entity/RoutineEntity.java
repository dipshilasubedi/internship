package com.example.RoutineCrudProject.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="tbl_routine")
public class RoutineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject_name")
    private String subjectName;
    @Column(name = "time")
    private String time;
    @Column(name = "teacher_name")
    private String teacherName;
    @Column(name = "credit_hour")
    private String creditHour;
    @Column(name = "day")
    private String day;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name="program_id")
    private ProgramEntity program;
}
