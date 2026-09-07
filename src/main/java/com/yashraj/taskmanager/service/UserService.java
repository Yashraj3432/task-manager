package com.yashraj.taskmanager.service;


import com.yashraj.taskmanager.dto.LoginRequest;
import com.yashraj.taskmanager.dto.LoginResponse;
import com.yashraj.taskmanager.entity.User;
import com.yashraj.taskmanager.exception.EmailAlreadyExistsException;
import com.yashraj.taskmanager.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository repo,
                       BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = repo;
        this.passwordEncoder = passwordEncoder;
    }


    public User registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");

        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRepository.save(user);
    }

    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid credentials"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid credentials");
        }

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole().name()
        );
    }
}
