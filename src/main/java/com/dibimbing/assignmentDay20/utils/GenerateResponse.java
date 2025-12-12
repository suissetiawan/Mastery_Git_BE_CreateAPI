package com.dibimbing.assignmentDay20.utils;

import java.util.Map;
import java.util.LinkedHashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.dibimbing.assignmentDay20.entity.User; 
import com.dibimbing.assignmentDay20.dto.UserResponseDTO;


public class GenerateResponse {

    public static UserResponseDTO mappedResponse(User user) {

        if (user == null) {
            return null;
        }

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setAddress(user.getAddress());
        userResponseDTO.setAge(user.getAge());
        return userResponseDTO;
    }

    public static ResponseEntity<Map<String, Object>> generate (String message, HttpStatus status, Object data) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("message", message);
        if (data != null) {
            response.put("data", data);
        }
        
        return ResponseEntity.status(status).body(response);
    }
}
