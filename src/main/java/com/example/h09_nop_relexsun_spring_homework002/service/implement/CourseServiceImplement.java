package com.example.h09_nop_relexsun_spring_homework002.service.implement;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.CourseRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Course;
import com.example.h09_nop_relexsun_spring_homework002.repository.CourseRepository;
import com.example.h09_nop_relexsun_spring_homework002.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImplement implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses(Integer page, Integer size) {
        return this.courseRepository.getAllCourses(page, size);
    }

    @Override
    public Course getCourseById(Long id) {
        return this.courseRepository.getCourseById(id);
    }

    @Override
    public void deleteCourseById(Long id) {
        this.courseRepository.deleteCourseById(id);
    }

    @Override
    public Course createCourse(CourseRequest request) {
        return this.courseRepository.createCourse(request);
    }

    @Override
    public Course updateCourse(Long id, CourseRequest request) {
        return this.courseRepository.updateCourse(id, request);
    }
}
