package com.example.Lesson_72_HOMEWORK.repository;

import com.example.Lesson_72_HOMEWORK.entity.CourseEntity;
import com.example.Lesson_72_HOMEWORK.entity.StudentCourseMarkEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface StudentCourseRepository extends CrudRepository<StudentCourseMarkEntity,Integer> {


    List<StudentCourseMarkEntity> findAllByStudentIdAndCreateddate(Integer id, LocalDate date);

    @Query("FROM StudentCourseMarkEntity WHERE student.id =:studentId AND createddate >:fromDate AND createddate <:toDate")
    Iterable<StudentCourseMarkEntity> findAllByStudentIdAndCreatedDateBeforeAndCreatedDateAfter(@Param("studentId") Integer studentId,
                                                                                            @Param("fromDate") LocalDateTime fromDate,
                                                                                            @Param("toDate") LocalDateTime toDate);

    Iterable<StudentCourseMarkEntity> findAllByStudentIdOrderByCreatedDateDesc(Integer studentId);

//    @Query("SELECT  FROM Stude WHERE student.id =:studentId ORDER BY createdDate ASC ")
//    List<Float> findAllByStudentIdOrderByCreatedDateDescSql(@Param("studentId") Integer studentId);

    List<StudentCourseMarkEntity> getStudentCourseEntitiesByStudentIdAndCourseIdOrderByCreatedDateDesc(Integer studentId, Integer courseId);
    @Query("SELECT mark FROM StudentCourseMarkEntity WHERE student.id =:studentId AND course.id =:courseId ORDER BY createddate ASC ")
    List<Float> getStudentCourseEntitiesByStudentIdAndCourseIdOrderByCreatedDateDescsql(@Param("studentId") Integer studentId,
                                                                                        @Param("courseId") Integer courseId);

}
