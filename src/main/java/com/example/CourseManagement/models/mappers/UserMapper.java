package com.example.CourseManagement.models.mappers;
import com.example.CourseManagement.data.entities.Role;
import com.example.CourseManagement.data.entities.User;
import com.example.CourseManagement.models.dto.UserLoginDTO;
import com.example.CourseManagement.models.dto.UserRegistrationDTO;
import com.example.CourseManagement.models.dto.UserViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    @Autowired
    private PasswordEncoder passwordEncoder;


    public User toUser(UserRegistrationDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.valueOf(dto.getRole()));
        return user;
    }


    public User toUser(UserLoginDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }


    public UserViewDTO toView(User user) {
        UserViewDTO dto = new UserViewDTO();
        dto.setUserId(user.getUserId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole().name());
        return dto;
    }

}
