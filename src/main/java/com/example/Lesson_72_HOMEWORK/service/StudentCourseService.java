package com.example.Lesson_72_HOMEWORK.service;

import com.example.Lesson_72_HOMEWORK.dto.Course;
import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.dto.StudentCourseMark;
import com.example.Lesson_72_HOMEWORK.entity.CourseEntity;
import com.example.Lesson_72_HOMEWORK.entity.StudentCourseMarkEntity;
import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import com.example.Lesson_72_HOMEWORK.exception.AppBadRequestExp;
import com.example.Lesson_72_HOMEWORK.repository.CourseRepository;
import com.example.Lesson_72_HOMEWORK.repository.StudentCourseRepository;
import com.example.Lesson_72_HOMEWORK.repository.StudentRepository;
import com.fasterxml.jackson.core.PrettyPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService {
    @Autowired
    private StudentCourseRepository studentcourseRepostory;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;


    public StudentCourseMark create(StudentCourseMark dto) {
        StudentCourseMarkEntity entity = new StudentCourseMarkEntity();
        StudentEntity student = studentRepository.findById(dto.getStudentid()).get();
        CourseEntity course = courseRepository.findById(dto.getCourseID()).get();
        entity.setStudent(student);
        entity.setCourse(course);
        entity.setMark(dto.getMark());
        studentcourseRepostory.save(entity);


        return dto;
    }


    public Boolean update(Integer id, StudentCourseMark studentCourseMark) {

        StudentCourseMarkEntity entity = get(id);

        StudentEntity student = studentRepository.findById(studentCourseMark.getStudentid()).get();
        CourseEntity course = courseRepository.findById(studentCourseMark.getCourseID()).get();
        entity.setId(studentCourseMark.getId());
        entity.setStudent(student);
        entity.setCourse(course);
        entity.setMark(studentCourseMark.getMark());
        entity.setCreateddate(studentCourseMark.getCreatedDate());
        studentcourseRepostory.save(entity);
        return true;
    }

    public StudentCourseMarkEntity get(Integer id) {
        Optional<StudentCourseMarkEntity> optional = studentcourseRepostory.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestExp("Student not found: " + id);
        }
        return optional.get();
    }

    public Object findname(Integer id) {

        return null;
    }

    public Object findmarkanddate(Integer id, LocalDate date) {
        StudentCourseMarkEntity entity1 = get(id);
        List<StudentCourseMarkEntity> courseEntities = studentcourseRepostory.findAllByStudentIdAndCreateddate(id, date);
        List<StudentCourseMark> courselist = new LinkedList<>();
        for (StudentCourseMarkEntity entity : courseEntities) {
            StudentCourseMark studentCourseMark = new StudentCourseMark();
            studentCourseMark.setId(entity.getId());
            studentCourseMark.setCreatedDate(entity.getCreateddate());
            studentCourseMark.setMark(entity.getMark());
            studentCourseMark.setCourseID(entity.getCourse().getId());
            studentCourseMark.setStudentid(entity.getStudent().getId());

            courselist.add(studentCourseMark);

        }
        return courselist;
    }

    public List<StudentCourseMark> getMarkByStudentAndCreatedDate(Integer studentId, LocalDate startDate) {
        return null;
    }
}
