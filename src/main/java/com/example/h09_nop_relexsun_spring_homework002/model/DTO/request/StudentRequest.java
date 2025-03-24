package com.example.h09_nop_relexsun_spring_homework002.model.DTO.request;

import com.example.h09_nop_relexsun_spring_homework002.model.entity.Course;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class StudentRequest {
    @NotNull
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Student name must be between 3 and 50 characters")
    private String studentName;
    @NotNull
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid", regexp = "^[A-Za-z0-9+_.-]+@gmail.com")
    private String email;
    @NotNull
    @Pattern(regexp = "^0[1,9]\\d{7,8}$", message="Invalid Phone number")
    private String phoneNumber;
    private List<Long> coursesId;
}
