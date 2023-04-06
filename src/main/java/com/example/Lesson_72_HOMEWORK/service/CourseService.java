package com.example.Lesson_72_HOMEWORK.service;

import com.example.Lesson_72_HOMEWORK.dto.Course;
import com.example.Lesson_72_HOMEWORK.dto.Student;
import com.example.Lesson_72_HOMEWORK.entity.CourseEntity;
import com.example.Lesson_72_HOMEWORK.entity.StudentEntity;
import com.example.Lesson_72_HOMEWORK.exception.AppBadRequestExp;
import com.example.Lesson_72_HOMEWORK.repository.CourseRepository;
import com.example.Lesson_72_HOMEWORK.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course create(Course course) {
        CourseEntity entity = new CourseEntity();

        entity.setId(course.getId());
        entity.setName(course.getName());
        entity.setDuration(course.getDuration());
        entity.setPrice(course.getPrice());

        courseRepository.save(entity);

        return course;
    }

    public Course getById(Integer id) {
        CourseEntity entity = get(id);
        Course dto = new Course();


        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        dto.setCreatedDate(entity.getCreateddate());

        return dto;
    }

    public CourseEntity get(Integer id) {
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()) {
            throw new AppBadRequestExp("Student not found: " + id);
        }
        return optional.get();
    }

    public List<Course> getAll() {
        Iterable<CourseEntity> iterable = courseRepository.findAll();
        List<Course> dtoList = new LinkedList<>();

        iterable.forEach(entity -> {
            Course dto = new Course();
             setAllCourse(dto);
            dtoList.add(dto);
        });
        return dtoList;

    }

    public Course setAllCourse(Course course){
        CourseEntity entity = new CourseEntity();
        Course dto = new Course();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDuration(entity.getDuration());
        dto.setCreatedDate(entity.getCreateddate());

        return dto;
    }

    public Boolean update(Integer id, Course courseDTo) {
        CourseEntity entity = get(id);

        entity.setName(courseDTo.getName());
       entity.setPrice(entity.getPrice());
       entity.setDuration(entity.getDuration());
       entity.setCreateddate(entity.getCreateddate());

        courseRepository.save(entity);
        return true;
    }


    public Boolean delete(Integer id) {

            CourseEntity entity = get(id);
            courseRepository.delete(entity);


        return true;
    }

    public List<CourseEntity> findname(String name) {


        List<CourseEntity>studentEntities = courseRepository.getAllByName(name);
        List<CourseEntity> studentList = new LinkedList<>();
        for(CourseEntity entity : studentEntities){
            Course studentDTO = new Course();

         setAllCourse(studentDTO);
            studentList.add(entity);

        }

        return studentList;
    }

    public List<CourseEntity> findprice(String price) {

        List<CourseEntity>studentEntities = courseRepository.getAllByPrice(price);
        List<CourseEntity> studentList = new LinkedList<>();
        for(CourseEntity entity : studentEntities){
            Course studentDTO = new Course();

            setAllCourse(studentDTO);
            studentList.add(entity);

        }

        return studentList;
    }

    public List<CourseEntity> findduration(String duration) {

        List<CourseEntity>studentEntities = courseRepository.getAllByDuration(duration);
        List<CourseEntity> studentList = new LinkedList<>();
        for(CourseEntity entity : studentEntities){
            Course studentDTO = new Course();

            setAllCourse(studentDTO);
            studentList.add(entity);

        }

        return studentList;
    }

    public List<Course> findbetweenprice(Double startprice, Double endprice) {

        List<CourseEntity> courseEntities = courseRepository.getAllByPriceBetween(startprice,endprice);
        List<Course> courselist = new LinkedList<>();
        for(CourseEntity entity : courseEntities){
            Course courseDTO = new Course();
            courseDTO.setId(entity.getId());
            courseDTO.setCreatedDate(entity.getCreateddate());
            courseDTO.setName(entity.getName());
            courseDTO.setPrice(entity.getPrice());
            courseDTO.setDuration(entity.getDuration());

            courselist.add(courseDTO);

        }
        return courselist;


    }


    public List<Course> findbetweendate(LocalDate date1, LocalDate date2) {
        List<CourseEntity> courseEntities = courseRepository.getAllByCreateddateBetween(date1,date2);
        List<Course> courselist = new LinkedList<>();
        for(CourseEntity entity : courseEntities){
            Course courseDTO = new Course();
            courseDTO.setId(entity.getId());
            courseDTO.setCreatedDate(entity.getCreateddate());
            courseDTO.setName(entity.getName());
            courseDTO.setPrice(entity.getPrice());
            courseDTO.setDuration(entity.getDuration());

            courselist.add(courseDTO);

        }
        return courselist;
    }
}
