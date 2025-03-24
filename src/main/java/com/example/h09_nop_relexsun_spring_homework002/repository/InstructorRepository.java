package com.example.h09_nop_relexsun_spring_homework002.repository;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.InstructorRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Instructor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {
    @Results(id="instructorMapper", value = {
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructorName", column = "instructor_name"),
    })
    @Select("""
        SELECT * FROM instructors
        OFFSET #{page} LIMIT #{size};
    """)
    List<Instructor> getAllInstructors(Integer page, Integer size);

    @ResultMap("instructorMapper")
    @Select("""
        SELECT * FROM instructors WHERE instructor_id = #{instructorId};
    """)
    Instructor getInstructorById(Long instructorId);

    @ResultMap("instructorMapper")
    @Delete(("""
        DELETE FROM instructors WHERE instructor_id = #{instructorId};
    """))
    void deleteInstructorById(Long instructorId);

    @ResultMap("instructorMapper")
    @Select("""
        INSERT INTO instructors VALUES (default, #{request.instructorName}, #{request.email})
        RETURNING *;
    """)
    Instructor createInstructor(@Param("request") InstructorRequest request);

    @ResultMap("instructorMapper")
    @Select("""
        UPDATE instructors SET instructor_name = #{request.instructorName}, email = #{request.email}
        WHERE instructor_id = #{instructorId}
        RETURNING *;
    """)
    Instructor updateInstructor(Long instructorId, @Param("request") InstructorRequest request);
}
