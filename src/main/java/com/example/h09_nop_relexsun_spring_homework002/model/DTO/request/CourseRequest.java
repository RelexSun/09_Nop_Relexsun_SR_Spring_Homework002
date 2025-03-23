package com.example.h09_nop_relexsun_spring_homework002.model.DTO.request;

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
public class CourseRequest {
    @NotNull
    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 50, message = "Course name must be between 3 and 50 characters")
    private String courseName;
    @NotNull
    private String description;
    private Long instructorId;
}
