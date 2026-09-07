package com.yashraj.taskmanager.controller;


import com.yashraj.taskmanager.dto.LoginRequest;
import com.yashraj.taskmanager.dto.LoginResponse;
import com.yashraj.taskmanager.dto.RegisterRequest;
import com.yashraj.taskmanager.entity.User;
import com.yashraj.taskmanager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){

        this.userService = userService;

    }

    @PostMapping("/register")
    public User register(@Valid @RequestBody RegisterRequest request) {

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(User.Role.USER);

        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }
}
