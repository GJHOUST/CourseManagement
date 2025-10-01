package com.example.CourseManagement.models.services;

import com.example.CourseManagement.models.dto.UserLoginDTO;
import com.example.CourseManagement.models.dto.UserRegistrationDTO;
import com.example.CourseManagement.models.dto.UserViewDTO;

import java.util.List;

public interface UserService {

    UserViewDTO register(UserRegistrationDTO dto);
    UserViewDTO login(UserLoginDTO dto);
    List<UserViewDTO> getAllUsers();
    UserViewDTO getUserById(Long userId);
    void deleteUserById(Long userId);
}
