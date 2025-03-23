package com.example.h09_nop_relexsun_spring_homework002.service;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.CourseRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses(Integer page, Integer size);

    Course getCourseById(Long id);

    void deleteCourseById(Long id);

    Course createCourse(CourseRequest request);

    Course updateCourse(Long id, CourseRequest request);
}
