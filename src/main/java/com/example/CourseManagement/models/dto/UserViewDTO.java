package com.example.CourseManagement.models.dto;

import lombok.Data;

@Data
public class UserViewDTO {

    private Long userId;
    private String name;
    private String email;
    private String role;

}
