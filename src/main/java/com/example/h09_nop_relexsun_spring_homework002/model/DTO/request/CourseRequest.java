package com.example.h09_nop_relexsun_spring_homework002.model.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class CourseRequest {
    private String courseName;
    private String description;
    private Long instructorId;
}
