package com.example.Lesson_72_HOMEWORK.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Getter
@Setter
@ToString
public class StudentCourseMark {
    /// id,studentId,courseId,mark,createdDate,

    private Integer id;
    private Integer  studentid;
    private Integer courseID;
    private Integer mark;
    private LocalDate createdDate;
}
