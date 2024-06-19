package com.yashpawar5.User.Registration.Services;


import com.yashpawar5.User.Registration.Models.Authority;
import com.yashpawar5.User.Registration.Models.User;
import com.yashpawar5.User.Registration.Repositories.AuthorityRepository;
import com.yashpawar5.User.Registration.Repositories.UserRepository;
import com.yashpawar5.User.Registration.Requests.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;


public String registerUser(RegisterUserRequest registerUserRequest) {
    String username = registerUserRequest.getUsername();
    try {
        if (userRepository.existsByUsername(username)) {
            throw new Exception("Username '" + username + "' already exists.");
        }

        User user = User.builder()
                .username(username)
                .password(new BCryptPasswordEncoder().encode(registerUserRequest.getPassword()))
                .email(registerUserRequest.getEmail())
                .enabled(true)
                .build();
        user = userRepository.save(user);
        Authority authority = Authority.builder()
                .authority("ROLE_USER")
                .username(user.getUsername())
                .build();
        authorityRepository.save(authority);
        return "User registered successfully with User ID: " + user.getUserId();
    } catch (Exception e) {
        return e.getMessage();
    }
}


    public String fetchUser(String username) {
        try {
            if (!(userRepository.existsByUsername(username))) {
                throw new NoSuchElementException("Username '" + username + "' does not exist.");
            }
            User user = userRepository.findUserByUsername(username);
            return "Username: " + user.getUsername() + " Email: " + user.getEmail();
        } catch (NoSuchElementException e) {
            return e.getMessage();
        }
    }

}