package com.example.Lesson_72_HOMEWORK.controller;


import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.dto.StudentCourseMark;
import com.example.Lesson_72_HOMEWORK.service.StudentCourseService;
import com.example.Lesson_72_HOMEWORK.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/studentcourse")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentCourseMark studentCourseMark) {
        StudentCourseMark response = studentCourseService.create(studentCourseMark);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody StudentCourseMark studentCourseMark) {
        return ResponseEntity.ok(studentCourseService.update(id, studentCourseMark));
    }
    //      response (id,studentId,courseId,mark,create

    @GetMapping(value = "/studentid/{id}")
    public ResponseEntity findname(@PathVariable("studentid") Integer id) {
        return ResponseEntity.ok(studentCourseService.findname(id));
    }

    @GetMapping(value = "/getMarkByStudentAndCreatedDate")
    public ResponseEntity<List<StudentCourseMark>> getMarkByStudentAndCreatedDate (@RequestParam("studentId") Integer studentId,
                                                                                  @RequestParam("startDate") LocalDate startDate
                                                                                  {
        List<StudentCourseMark> list = studentCourseService.getMarkByStudentAndCreatedDate(studentId,startDate);
        return ResponseEntity.ok(list);
    }

}
