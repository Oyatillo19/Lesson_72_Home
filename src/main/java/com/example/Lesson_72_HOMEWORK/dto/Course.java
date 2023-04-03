package com.example.Lesson_72_HOMEWORK.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class Course {
//    id,name,price,duration,createdDate

    private Integer id;
    private String name;
    private Double price;
    private String duration;
    private LocalDate createdDate;
}
