package com.example.h09_nop_relexsun_spring_homework002.service.implement;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.InstructorRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Instructor;
import com.example.h09_nop_relexsun_spring_homework002.repository.InstructorRepository;
import com.example.h09_nop_relexsun_spring_homework002.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImplement implements InstructorService {
    private final InstructorRepository instructorRepository;

    @Override
    public List<Instructor> getAllInstructors(Integer page, Integer size) {
        return this.instructorRepository.getAllInstructors(page, size);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return this.instructorRepository.getInstructorById(id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        this.instructorRepository.deleteInstructorById(id);
    }

    @Override
    public Instructor createInstructor(InstructorRequest request) {
        return this.instructorRepository.createInstructor(request);
    }

    @Override
    public Instructor updateInstructor(Long id, InstructorRequest request) {
        return this.instructorRepository.updateInstructor(id, request);
    }
}
