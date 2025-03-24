package com.example.h09_nop_relexsun_spring_homework002.controller;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.CourseRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.DTO.response.APIResponse;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Course;
import com.example.h09_nop_relexsun_spring_homework002.service.implement.CourseServiceImplement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImplement courseServiceImplement;

    @GetMapping
    public ResponseEntity<APIResponse<List<Course>>> getAllCourses(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        page = (page - 1) * size;
        List<Course> courses = this.courseServiceImplement.getAllCourses(page, size);
        APIResponse<List<Course>> response = APIResponse.<List<Course>>builder().message("success").payload(courses).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{course-id}")
    public ResponseEntity<APIResponse<Course>> getCourseById(@PathVariable("course-id") Long id) {
        Course course = this.courseServiceImplement.getCourseById(id);
        APIResponse<Course> response = APIResponse.<Course>builder().message("success").payload(course).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{course-id}")
    public ResponseEntity<APIResponse<Course>> deleteCourseById(@PathVariable("course-id") Long id) {
        this.courseServiceImplement.deleteCourseById(id);
        APIResponse<Course> response = APIResponse.<Course>builder().message("Course deleted successfully").payload(null).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Course>> createCourse(@Valid @RequestBody CourseRequest request) {
        Course course = this.courseServiceImplement.createCourse(request);
        APIResponse<Course> response = APIResponse.<Course>builder().message("Course created successfully").payload(course).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{course-id}")
    public ResponseEntity<APIResponse<Course>> updateCourse(@Valid @PathVariable("course-id") Long id, @RequestBody CourseRequest request) {
        Course course = this.courseServiceImplement.updateCourse(id, request);
        APIResponse<Course> response = APIResponse.<Course>builder().message("Updated course successfully").payload(course).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
