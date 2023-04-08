package com.example.Lesson_72_HOMEWORK.entity;

import com.example.Lesson_72_HOMEWORK.dto.Course;
import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.enums.StudentGender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "studentcoursemark")

public class StudentCourseMarkEntity {
    /// id,studentId,courseId,mark,createdDate,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

     @JoinColumn(name = "student_id")
     @ManyToOne(fetch = FetchType.LAZY)
    private  StudentEntity student;
    @JoinColumn(name = "course_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private CourseEntity course;
    @Column(name = "mark")
    private Integer mark;
    @Column(name = "createddate")
    private LocalDate createddate =LocalDate.now();



}
