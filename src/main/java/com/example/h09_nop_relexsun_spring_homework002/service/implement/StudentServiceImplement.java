package com.example.h09_nop_relexsun_spring_homework002.service.implement;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.StudentRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Student;
import com.example.h09_nop_relexsun_spring_homework002.repository.StudentCourseRepository;
import com.example.h09_nop_relexsun_spring_homework002.repository.StudentRepository;
import com.example.h09_nop_relexsun_spring_homework002.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImplement implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository;

    @Override
    public List<Student> getAllStudent(Integer page, Integer size) {
        page = (page - 1) * size;
        return this.studentRepository.getAllStudent(page, size);
    }

    @Override
    public Student createStudent(StudentRequest request) {
        Student student = this.studentRepository.createStudent(request);
        for (Long courseId : request.getCoursesId()) {
            studentCourseRepository.createStudentCourse(student.getStudentId(), courseId);
        }
        return getStudentById(student.getStudentId());
    }

    @Override
    public Student updateStudent(Long id, StudentRequest request) {
        return this.studentRepository.updateStudent(id, request);
    }

    @Override
    public Student getStudentById(Long id) {
        return this.studentRepository.getStudentById(id);
    }

    @Override
    public void deleteStudentById(Long id) {
        this.studentRepository.deleteStudentById(id);
    }
}
