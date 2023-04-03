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
@Table(name = "student")

public class StudentEntity {

    //// id,name,surname,level,age,Gender,createdDate

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname", nullable = false)
    private String surname;
    @Column(name = "level")
    private String level;

    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private StudentGender gender;


    @Column(name = "createddate")
    private LocalDate createddate;





}
