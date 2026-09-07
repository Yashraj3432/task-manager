package com.yashraj.taskmanager.service;


import com.yashraj.taskmanager.entity.User;
import com.yashraj.taskmanager.exception.EmailAlreadyExistsException;
import com.yashraj.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;

    }
    public User registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already registered");
        }

        return userRepository.save(user);
    }

}
