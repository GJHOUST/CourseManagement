package com.example.CourseManagement.models.services;
import com.example.CourseManagement.data.entities.User;
import com.example.CourseManagement.data.repositories.UserRepository;
import com.example.CourseManagement.models.dto.UserLoginDTO;
import com.example.CourseManagement.models.dto.UserRegistrationDTO;
import com.example.CourseManagement.models.dto.UserViewDTO;
import com.example.CourseManagement.models.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public UserViewDTO register(UserRegistrationDTO dto) {
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new IllegalArgumentException("Hesla se neshoduji");
        }

        User user = userMapper.toUser(dto);
        userRepository.save(user);
        return userMapper.toView(user);
    }

    public UserViewDTO login(UserLoginDTO dto) {
        User user = userRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Neplatny email nebo heslo"));


        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Neplatny email nebo heslo");
        }

        return userMapper.toView(user);
    }

    public List<UserViewDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toView)
                .toList();
    }


    public UserViewDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Uzivatel nenalezen"));
        return userMapper.toView(user);
    }


    public void deleteUserById(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new IllegalArgumentException("Uzivatel nenalezen");
        }
        userRepository.deleteById(userId);
    }

}
