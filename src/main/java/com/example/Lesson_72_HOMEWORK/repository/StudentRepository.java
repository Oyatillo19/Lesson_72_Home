package com.example.Lesson_72_HOMEWORK.repository;

import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.ModelAttribute;

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


//    @Transactional
//    @Modifying
//    @Query("update StudentEntity set gender=:gender where id =:sid")
//    Integer changeVisibility(@Param("sid")Integer sid,@Param( "gender")Boolean v);
//
//    @Query("from  StudentEntity  where name like ?1")
//    List <StudentEntity> findbyname2(String name);

//    @Query("select new StudentEntity  (id,name,surname) from StudentEntity ")
//    List <StudentEntity> findbyname7();

//    @Query("SELECT new com.example.mapper.StudentMapper(id,name, phone) FROM StudentEntity ")
//    List<StudentMapper> findByName5();


}
