package com.example.h09_nop_relexsun_spring_homework002.controller;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.StudentRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.DTO.response.APIResponse;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Student;
import com.example.h09_nop_relexsun_spring_homework002.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<APIResponse<List<Student>>> getAllStudent(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        List<Student> students = this.studentService.getAllStudent(page, size);
        APIResponse<List<Student>> response = APIResponse.<List<Student>>builder().message("success").payload(students).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Student>> createStudent(@Valid @RequestBody StudentRequest request) {
        Student student = this.studentService.createStudent(request);
        APIResponse<Student> response = APIResponse.<Student>builder().message("success").payload(student).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{student-id}")
    public ResponseEntity<APIResponse<Student>> updateStudent(@PathVariable("student-id") Long id, @Valid @RequestBody StudentRequest request) {
        Student student = this.studentService.updateStudent(id, request);
        APIResponse<Student> response = APIResponse.<Student>builder().message("success").payload(student).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{student-id}")
    public ResponseEntity<APIResponse<Student>> getStudentById(@PathVariable("student-id") Long id) {
        Student student = this.studentService.getStudentById(id);
        APIResponse<Student> response = APIResponse.<Student>builder().message("success").payload(student).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<APIResponse<Student>> deleteStudentById(@PathVariable("student-id") Long id) {
        this.studentService.deleteStudentById(id);
        APIResponse<Student> response = APIResponse.<Student>builder().message("Student deleted successfully").payload(null).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
