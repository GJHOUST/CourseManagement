package com.example.CourseManagement.models.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseCreateDTO {

    @NotBlank(message = "Vyplnte pole")
    private String title;

    @NotBlank(message = "Vyplnte pole")
    private String description;

}
