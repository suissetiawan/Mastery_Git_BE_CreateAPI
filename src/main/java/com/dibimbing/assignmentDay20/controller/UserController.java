package com.dibimbing.assignmentDay20.controller;
import org.springframework.web.bind.annotation.*;
import com.dibimbing.assignmentDay20.dto.*;
import com.dibimbing.assignmentDay20.service.*;
import java.util.Map;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {"", "/"})
    public String check() {
        return "Hallo Friend, please register first using /api/users/register";
    }

    @GetMapping("/register")
    public ResponseEntity<Map<String, Object>> userRegister(RegisterRequestDTO user) {
        return userService.registerUser(user);
    }

    @GetMapping("/login")
    public ResponseEntity<Map<String, Object>> userLogin(LoginRequestDTO request){
        return userService.loginUser(request);
    }

    @GetMapping("{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable String id){
        return userService.GetUserById(id);
    }

}