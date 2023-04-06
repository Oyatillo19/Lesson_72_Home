package com.example.Lesson_72_HOMEWORK.repository;

import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository  extends CrudRepository <StudentEntity,Integer> {
// (getByName, getBySurname, getByLevel, getByAge, getByGender)
// (getByName, getBySurname, getByLevel, getByAge, getByGender)
    List<StudentEntity> getAllByName(String name);
    List<StudentEntity> getAllBySurname(String surname);
    List<StudentEntity> getAllByLevel(String level);
    List<StudentEntity> getAllByAge(String age);
    List<StudentEntity> getAllByGender(String gender);
    List<StudentEntity> getAllByCreatedDate(LocalDate date);
    List<StudentEntity> getAllByCreatedDateBetween(LocalDate startdate,LocalDate enddate);


}
