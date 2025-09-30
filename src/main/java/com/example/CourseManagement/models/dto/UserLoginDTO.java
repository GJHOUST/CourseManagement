package com.example.CourseManagement.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserLoginDTO {

    @Email(message = "Vyplnte spravny format")
    @NotBlank(message = "Vyplnte email")
    private String email;

    @NotBlank(message = "vyplnte heslo")
    private String password;

}
