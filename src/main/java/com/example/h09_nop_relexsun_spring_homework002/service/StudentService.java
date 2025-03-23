package com.example.h09_nop_relexsun_spring_homework002.service;


import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.StudentRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent(Integer page, Integer size);

    Student createStudent(StudentRequest request);

    Student updateStudent(Long id, StudentRequest request);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);
}
