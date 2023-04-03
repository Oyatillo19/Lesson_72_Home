package com.example.Lesson_72_HOMEWORK.repository;

import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository  extends CrudRepository <StudentEntity,Integer> {


}
