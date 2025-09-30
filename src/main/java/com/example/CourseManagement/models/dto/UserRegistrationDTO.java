package com.example.CourseManagement.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegistrationDTO {

    @NotBlank(message = "Vyplnte jmeno")
    private String name;

    @Email(message = "Vyplnte spravny format")
    @NotBlank(message = "Vyplnte email")
    private String email;

    @NotBlank(message = "vyplnte heslo")
    @Size(min = 6, message = "Heslo musi mit alespon 6 znaku")
    private String password;

    @NotBlank(message = "vyplnte heslo")
    @Size(min = 6, message = "Heslo musi mit alespon 6 znaku")
    private String confirmPassword;

    private String role;

}
