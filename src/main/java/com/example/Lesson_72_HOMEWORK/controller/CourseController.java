package com.example.Lesson_72_HOMEWORK.controller;


import com.example.Lesson_72_HOMEWORK.dto.Course;
import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.service.CourseService;
import com.example.Lesson_72_HOMEWORK.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Course course) {
        Course response = courseService.create(course);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id) {
        Course dto = courseService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Course>> getAll() {
        List<Course> list = courseService.getAll();
        return ResponseEntity.ok(list);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Course courseDTo) {
        return ResponseEntity.ok(courseService.update(id, courseDTo));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(courseService.delete(id));
    }

    ////(getByName, getByPrice,getByDuration)
    @GetMapping(value = "/name/{name}")
    public ResponseEntity findname(@PathVariable("name") String name) {
        return ResponseEntity.ok(courseService.findname(name));
    }

    @GetMapping(value = "/price/{price}")
    public ResponseEntity findprice(@PathVariable("price") String price) {
        return ResponseEntity.ok(courseService.findprice(price));
    }

    @GetMapping(value = "/duration/{duration}")
    public ResponseEntity findduration(@PathVariable("duration") String duration) {
        return ResponseEntity.ok(courseService.findduration(duration));
    }

//     7. Get Course list between given 2 prices.

    @GetMapping(value = "/betweenprice/{price1}/{price2}")
    public ResponseEntity findbetweenprice(@PathVariable("price1") Double startprice,
                                          @PathVariable("price2") Double endprice) {
        List<Course> list =courseService.findbetweenprice(startprice,endprice);
        return ResponseEntity.ok(list);
    }

    //  8. Get Course list between 2 createdDates
    @GetMapping(value = "/betweendate/{date1}/{date2}")
    public ResponseEntity findbetweendate(@PathVariable("date1") LocalDate date1,
                                           @PathVariable("date2") LocalDate date2) {
        List<Course> list =courseService.findbetweendate(date1,date2);
        return ResponseEntity.ok(list);
    }


}
