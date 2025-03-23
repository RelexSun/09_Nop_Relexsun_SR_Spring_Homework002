package com.example.h09_nop_relexsun_spring_homework002.service;


import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.InstructorRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Instructor;

import java.util.List;

public interface InstructorService {
    List<Instructor> getAllInstructors(Integer page, Integer size);

    Instructor getInstructorById(Long id);

    void deleteInstructorById(Long id);

    Instructor createInstructor(InstructorRequest request);

    Instructor updateInstructor(Long id, InstructorRequest request);
}
