package com.example.Lesson_72_HOMEWORK.controller;


import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
@Autowired
private StudentService studentService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Student student) {
        Student response = studentService.create(student);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> list = studentService.getAll();
        return ResponseEntity.ok(list);
    }

    //  3. Get student by id.


    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Student dto = studentService.getById(id);
        return ResponseEntity.ok(dto);
    }

    //  4. Update student.

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Student studentDTO) {
        return ResponseEntity.ok(studentService.update(id, studentDTO));
    }

    //  5. Delete Student by id.

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(studentService.delete(id));
    }

//      . Get method by each field. (getByName, getBySurname, getByLevel, getByAge, getByGender)

    @GetMapping(value = "/name/{name}")
    public ResponseEntity findname(@PathVariable("name") String name) {
        return ResponseEntity.ok(studentService.findname(name));
    }

    @GetMapping(value = "/surname/{surname}")
    public ResponseEntity findsurname(@PathVariable("surname") String surname) {
        return ResponseEntity.ok(studentService.findsurname(surname));
    }

    @GetMapping(value = "/level/{level}")
    public ResponseEntity findlevel(@PathVariable("level") String level) {
        return ResponseEntity.ok(studentService.findlevel(level));
    }

    @GetMapping(value = "/age/{age}")
    public ResponseEntity findage(@PathVariable("age") String age) {
        return ResponseEntity.ok(studentService.findage(age));
    }

    @GetMapping(value = "/gender/{gender}")
    public ResponseEntity findgender(@PathVariable("gender") String gender) {
        return ResponseEntity.ok(studentService.findgender(gender));
    }

    @GetMapping(value = "/date/{date}")
    public ResponseEntity finddate(@PathVariable("date") LocalDate date) {
        return ResponseEntity.ok(studentService.finddate(date));
    }

    @GetMapping(value = "/betweendate/{date}")
    public ResponseEntity findbetweendate(@PathVariable("startdate") LocalDate startdate,
                                          @PathVariable("endate") LocalDate enddate) {
        return ResponseEntity.ok(studentService.findbetweendate(startdate,enddate));
    }
}
