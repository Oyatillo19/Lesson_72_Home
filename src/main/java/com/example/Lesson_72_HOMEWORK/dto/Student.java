package com.example.Lesson_72_HOMEWORK.dto;

import com.example.Lesson_72_HOMEWORK.enums.StudentGender;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public class Student {
 private  Integer id;
  private  String name;
  private  String surname;
  private  String level;
  private  Integer age;
  private StudentGender gender;
  private LocalDate createdDate;

}
