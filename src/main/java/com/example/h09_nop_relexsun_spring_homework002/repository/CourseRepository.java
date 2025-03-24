package com.example.h09_nop_relexsun_spring_homework002.repository;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.CourseRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {
    @Results(id= "courseMapper", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "courseName", column = "course_name"),
            @Result(property = "instructor", column = "instructor_id", one = @One(select = "com.example.h09_nop_relexsun_spring_homework002.repository.InstructorRepository.getInstructorById"))
    })
    @Select("""
        SELECT * FROM courses
        OFFSET #{page} LIMIT #{size}
    """)
    List<Course> getAllCourses(Integer page, Integer size);

    @ResultMap("courseMapper")
    @Select("""
        SELECT * FROM courses WHERE course_id = #{courseId}
    """)
    Course getCourseById(Long courseId);

    @ResultMap("courseMapper")
    @Delete("""
        DELETE FROM courses WHERE course_id = #{courseId}
    """)
    void deleteCourseById(Long courseId);

    @ResultMap("courseMapper")
    @Select("""
        INSERT INTO courses VALUES (default, #{request.courseName}, #{request.description}, #{request.instructorId})
        RETURNING *;
    """)
    Course createCourse(@Param("request") CourseRequest request);

    @ResultMap("courseMapper")
    @Select("""
        UPDATE courses SET course_name = #{request.courseName},
                       description = #{request.description},
                    instructor_id = #{request.instructorId}
                   WHERE course_id = #{courseId}
        RETURNING *;
    """)
    Course updateCourse(Long courseId, @Param("request") CourseRequest request);
}
