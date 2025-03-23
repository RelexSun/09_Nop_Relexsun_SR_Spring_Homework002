package com.example.h09_nop_relexsun_spring_homework002.repository;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.StudentRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface StudentRepository {

        @Results(id="studentMapper", value={
                @Result(property = "studentId", column = "student_id"),
                @Result(property = "studentName", column = "student_name"),
                @Result(property = "phoneNumber", column = "phone_number"),
                @Result(property = "courses", column = "student_id", many = @Many(select = "com.example.h09_nop_relexsun_spring_homework002.repository.StudentCourseRepository.getAllCoursesByStudentId"))
        })
        @Select("""
            SELECT * FROM students
            OFFSET #{page} LIMIT #{size};
        """)
        List<Student> getAllStudent(Integer page, Integer size);

        @ResultMap("studentMapper")
        @Select("""
            INSERT INTO students VALUES (default, #{request.studentName}, #{request.email}, #{request.phoneNumber})
            RETURNING *;
        """)
        Student createStudent(@Param("request") StudentRequest request);

        @ResultMap("studentMapper")
        @Select("""
            UPDATE students SET student_name = #{request.studentName}, email = #{request.email}, phone_number = #{request.phoneNumber} WHERE student_id = #{studentId}
            RETURNING *;
        """)
        Student updateStudent(Long studentId, @Param("request") @RequestBody StudentRequest request);

        @ResultMap("studentMapper")
        @Select("""
            SELECT * FROM students WHERE student_id = #{studentId};
            """)
        Student getStudentById(Long studentId);

        @Delete("""
            DELETE FROM students WHERE student_id = #{studentId};
        """)
        void deleteStudentById(Long studentId);
}
