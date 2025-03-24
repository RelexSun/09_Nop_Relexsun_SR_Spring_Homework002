package com.example.h09_nop_relexsun_spring_homework002.model.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class InstructorRequest {
    @NotNull
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Instructor name must be between 3 and 50 characters")
    private String instructorName;
    @NotNull
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid", regexp = "^[A-Za-z0-9+_.-]+@gmail.com")
    private String email;
}
