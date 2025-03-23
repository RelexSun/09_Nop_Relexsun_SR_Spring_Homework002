package com.example.h09_nop_relexsun_spring_homework002.repository;


import com.example.h09_nop_relexsun_spring_homework002.model.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {
    @Results(id = "studentCourseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.example.h09_nop_relexsun_spring_homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
        SELECT * FROM student_courses sc inner join courses c on c.course_id = sc.course_id where student_id = #{student_id};
    """)
    List<Course> getAllCoursesByStudentId(@Param("student_id") Long studentId);

    @Insert("""
        INSERT INTO student_courses VALUES (#{course_id}, #{student_id});
    """)
    void createStudentCourse(@Param("student_id") Long studentId, @Param("course_id") Long courseId);
}
