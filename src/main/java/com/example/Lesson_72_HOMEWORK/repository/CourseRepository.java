package com.example.Lesson_72_HOMEWORK.repository;

import com.example.Lesson_72_HOMEWORK.entity.CourseEntity;
import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity,Integer> {
    List<CourseEntity> getAllByName(String name);
    List<CourseEntity> getAllByPrice(String price);
    List<CourseEntity> getAllByDuration(String duration);
    List<CourseEntity> getAllByPriceBetween(Double startprice,Double endprice);
    List<CourseEntity> getAllByCreateddateBetween(LocalDate date1, LocalDate date2);

}
