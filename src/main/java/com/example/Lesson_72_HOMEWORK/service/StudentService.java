package com.example.Lesson_72_HOMEWORK.service;

import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import com.example.Lesson_72_HOMEWORK.exception.AppBadRequestExp;
import com.example.Lesson_72_HOMEWORK.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    /// id,name,surname,level,age,Gender,createdDate
    public Student create(Student dto) {
        StudentEntity entity = new StudentEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setLevel(dto.getLevel());
        entity.setAge(dto.getAge());
        entity.setGender(dto.getGender());
        entity.setCreatedDate(dto.getCreatedDate());
//
//
//        if (dto.getName() == null || dto.getName().isBlank()) {
//            throw new AppBadRequestExp("Name qani?");
//        }
//        if (dto.getSurname() == null || dto.getSurname().isBlank()) {
//            throw new AppBadRequestExp("Surname qani?");
//        }
        studentRepository.save(entity);
        dto.setId(entity.getId());
        dto.setGender(entity.getGender());
        dto.setAge(entity.getAge());
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


    public Student getById(Integer id) {
            StudentEntity entity = get(id);
            Student dto = new Student();


            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setLevel(entity.getLevel());
            dto.setAge(entity.getAge());
            dto.setGender(entity.getGender());
            dto.setCreatedDate(entity.getCreatedDate());
            return dto;


    }

    public boolean update(Integer id, Student studentDTO) {
        //// id,name,surname,level,age,Gender,createdDate

        StudentEntity entity = get(id);

        entity.setName(studentDTO.getName());
        entity.setSurname(studentDTO.getSurname());
        entity.setLevel(studentDTO.getLevel());
        entity.setAge(studentDTO.getAge());
        entity.setGender(studentDTO.getGender());
        entity.setCreatedDate(studentDTO.getCreatedDate());
        studentRepository.save(entity);
        return true;

    }

    public boolean delete(Integer id) {
            StudentEntity entity = get(id);
            studentRepository.delete(entity);
            return true;
    }


    public List<StudentEntity> findname(String name) {


        List<StudentEntity>studentEntities = studentRepository.getAllByName(name);
        List<StudentEntity> studentList = new LinkedList<>();
        for(StudentEntity entity : studentEntities){
            Student studentDTO = new Student();
            entity.setName(studentDTO.getName());
            entity.setSurname(studentDTO.getSurname());
            entity.setLevel(studentDTO.getLevel());
            entity.setAge(studentDTO.getAge());
            entity.setGender(studentDTO.getGender());
            entity.setCreatedDate(studentDTO.getCreatedDate());
            studentList.add(entity);

        }

        return studentList;
    }
}

