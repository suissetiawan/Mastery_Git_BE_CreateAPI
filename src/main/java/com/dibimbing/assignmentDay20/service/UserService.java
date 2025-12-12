package com.dibimbing.assignmentDay20.service;

import java.util.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dibimbing.assignmentDay20.entity.User;
import com.dibimbing.assignmentDay20.dto.*;
import org.springframework.http.HttpStatus;
import com.dibimbing.assignmentDay20.utils.GenerateResponse;
import com.dibimbing.assignmentDay20.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<Map<String, Object>> registerUser(RegisterRequestDTO request) {

        if (request.getUsername() == null) {
            return GenerateResponse.generate("Username is required", HttpStatus.BAD_REQUEST, null);
        } else if (request.getEmail() == null) {
            return GenerateResponse.generate("Email is required", HttpStatus.BAD_REQUEST, null);
        } else if (request.getPassword() == null) {
            return GenerateResponse.generate("Password is required", HttpStatus.BAD_REQUEST, null);
        } else if (request.getAge() == null) {
            return GenerateResponse.generate("Age is required", HttpStatus.BAD_REQUEST, null);
        }

        if (request.getUsername().length() < 5) {
            return GenerateResponse.generate("Username must be at least 5 characters long", HttpStatus.BAD_REQUEST, null);
        }

        if (request.getPassword().length() < 8) {
            return GenerateResponse.generate("Password must be at least 8 characters long", HttpStatus.BAD_REQUEST, null);
        }

        User cekDuplicate = userRepository.findByUsername(request.getUsername());
        if (cekDuplicate != null) {
            return GenerateResponse.generate("User already exists", HttpStatus.BAD_REQUEST, null);
        }

        User user = new User();
        user.setId(Long.valueOf(userRepository.findAll().size() + 1));
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setAddress(request.getAddress());
        user.setAge(request.getAge());   
        userRepository.save(user);

        UserResponseDTO res = GenerateResponse.mappedResponse(user);

        return GenerateResponse.generate("User registered successfully", HttpStatus.CREATED, res);
    }
}
