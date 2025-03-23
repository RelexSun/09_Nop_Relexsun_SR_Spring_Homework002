package com.example.h09_nop_relexsun_spring_homework002.controller;

import com.example.h09_nop_relexsun_spring_homework002.model.DTO.request.InstructorRequest;
import com.example.h09_nop_relexsun_spring_homework002.model.DTO.response.APIResponse;
import com.example.h09_nop_relexsun_spring_homework002.model.entity.Instructor;
import com.example.h09_nop_relexsun_spring_homework002.service.implement.InstructorServiceImplement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {
    private final InstructorServiceImplement instructorServiceImplement;

    @GetMapping
    public ResponseEntity<APIResponse<List<Instructor>>> getAllInstructors(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        page = (page - 1) * size;
        List<Instructor> instructors = this.instructorServiceImplement.getAllInstructors(page,  size);
        APIResponse<List<Instructor>> response = APIResponse.<List<Instructor>>builder().message("success").payload(instructors).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<APIResponse<Instructor>> createInstructor(@Valid  @RequestBody InstructorRequest request) {
        Instructor instructor = this.instructorServiceImplement.createInstructor(request);
        APIResponse<Instructor> response = APIResponse.<Instructor>builder().message("Instructor created successfully").payload(instructor).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{instructor-id}")
    public ResponseEntity<APIResponse<Instructor>> getInstructorById (@PathVariable("instructor-id") Long id) {
        Instructor instructor = this.instructorServiceImplement.getInstructorById(id);
        APIResponse<Instructor> response = APIResponse.<Instructor>builder().message("success").payload(instructor).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{instructor-id}")
    public ResponseEntity<APIResponse<Instructor>> deleteInstructorById(@PathVariable("instructor-id") Long id){
        this.instructorServiceImplement.deleteInstructorById(id);
        APIResponse<Instructor> response = APIResponse.<Instructor>builder().message("Instructor deleted successfully").payload(null).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{instructor-id}")
    public ResponseEntity<APIResponse<Instructor>> updateInstructor(@Valid @PathVariable("instructor-id") Long id, @RequestBody InstructorRequest request) {
        Instructor instructor = this.instructorServiceImplement.updateInstructor(id, request);
        APIResponse<Instructor> response = APIResponse.<Instructor>builder().message("Instructor updated successfully").payload(instructor).status(HttpStatus.OK).timestamp(Instant.now()).build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
