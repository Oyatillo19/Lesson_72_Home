package com.example.Lesson_72_HOMEWORK.service;

import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import com.example.Lesson_72_HOMEWORK.exception.AppBadRequestExp;
import com.example.Lesson_72_HOMEWORK.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    private StudentRepository studentRepository;

    public Student create(Student dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setCreateddate(dto.getCreatedDate());
        entity.setLevel(dto.getLevel());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());


        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestExp("Name qani?");
        }
        if (dto.getSurname() == null || dto.getSurname().isBlank()) {
            throw new AppBadRequestExp("Surname qani?");
        }

        studentRepository.save(entity);
        dto.setId(entity.getId());
        return dto;


    }

//    public Student getStudentList(Integer id) {
//        StudentEntity entity = get(id);
//        Student dto = new StudentDTO();
//        dto.setId(entity.getId());
//        dto.setName(entity.getName());
//        dto.setSurname(entity.getSurname());
//        //...
//        return dto;
//
//    }

    public StudentEntity get(Integer id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestExp("Student not found: " + id);
        }
        return optional.get();
    }

    public List<Student> getAll() {
        Iterable<StudentEntity> iterable = studentRepository.findAll();
        List<Student> dtoList = new LinkedList<>();

        iterable.forEach(entity -> {
            Student dto = new Student();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setGender(entity.getGender());
            dto.setAge(dto.getAge());
            dtoList.add(dto);
        });
        return dtoList;
    }
}
