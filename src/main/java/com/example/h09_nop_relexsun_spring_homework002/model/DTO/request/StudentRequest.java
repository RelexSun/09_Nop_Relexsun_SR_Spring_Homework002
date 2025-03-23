package com.example.h09_nop_relexsun_spring_homework002.model.DTO.request;

import com.example.h09_nop_relexsun_spring_homework002.model.entity.Course;
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
    private String studentName;
    private String email;
    private String phoneNumber;
    private List<Long> coursesId;
}
