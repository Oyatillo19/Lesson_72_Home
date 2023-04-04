package com.example.Lesson_72_HOMEWORK.repository;

import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository  extends CrudRepository <StudentEntity,Integer> {
// (getByName, getBySurname, getByLevel, getByAge, getByGender)
    List<StudentEntity> getAllByName(String name);
}
