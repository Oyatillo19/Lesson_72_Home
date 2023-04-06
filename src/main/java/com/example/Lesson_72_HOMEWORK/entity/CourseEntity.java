package com.example.Lesson_72_HOMEWORK.entity;

import com.example.Lesson_72_HOMEWORK.enums.StudentGender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

@Table(name = "course")
public class CourseEntity {
    ////    id,name,price,duration,createdDate

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "duration")
    private String duration;

    @Column(name = "createddate" )
    private LocalDate createddate=LocalDate.now();



}
