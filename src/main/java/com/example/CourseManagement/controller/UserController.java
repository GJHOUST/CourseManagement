package com.example.CourseManagement.controller;
import com.example.CourseManagement.models.dto.UserLoginDTO;
import com.example.CourseManagement.models.dto.UserRegistrationDTO;
import com.example.CourseManagement.models.dto.UserViewDTO;
import com.example.CourseManagement.models.services.UserServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @PostMapping("/register")
    public ResponseEntity<UserViewDTO> register(@Valid @RequestBody UserRegistrationDTO dto) {
        UserViewDTO savedUser = userServiceImp.register(dto);
        return ResponseEntity.ok(savedUser);
    }


    @PostMapping("/login")
    public ResponseEntity<UserViewDTO> login(@Valid @RequestBody UserLoginDTO dto) {
        UserViewDTO user = userServiceImp.login(dto);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserViewDTO>> getAllUsers() {
        return ResponseEntity.ok(userServiceImp.getAllUsers());
    }


    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userServiceImp.getUserById(userId));
    }


    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long userId) {
        userServiceImp.deleteUserById(userId);
        return ResponseEntity.noContent().build();
    }

}
