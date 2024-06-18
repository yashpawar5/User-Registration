package com.yashpawar5.User.Registration.Services;


import com.yashpawar5.User.Registration.Models.Authority;
import com.yashpawar5.User.Registration.Models.User;
import com.yashpawar5.User.Registration.Repositories.AuthorityRepository;
import com.yashpawar5.User.Registration.Repositories.UserRepository;
import com.yashpawar5.User.Registration.Requests.RegisterUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthorityRepository authorityRepository;

    public UserService() {
    }

    public String registerUser(RegisterUserRequest registerUserRequest) {
        User user = User.builder()
                .username(registerUserRequest.getUserName())
                .password(registerUserRequest.getPassword())
                .email(registerUserRequest.getEmail())
                .enabled(true)
                .build();
        user = userRepository.save(user);
        Authority authority = Authority.builder()
                .authority("ROLE_USER")
                .username(user.getUsername())
                .build();
       authority = authorityRepository.save(authority);
        return "User registered successfully with User ID: " + user.getUserId();
    }

    public String fetchUser(String username) {
        User user = userRepository.findUserByUsername(username);
        Integer userId = user.getUserId();
        return "Username: " + user.getUsername() +" Email: " + user.getEmail();
    }
}