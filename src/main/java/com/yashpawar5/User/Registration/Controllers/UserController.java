package com.yashpawar5.User.Registration.Controllers;

import com.yashpawar5.User.Registration.Requests.RegisterUserRequest;
import com.yashpawar5.User.Registration.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController() {
    }

    @PostMapping({"/register"})
    public ResponseEntity registerUser(@RequestBody RegisterUserRequest registerUserRequest) {
        String response = userService.registerUser(registerUserRequest);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping({"/fetch"})
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity fetchUser(@RequestParam String username) {
        String response = userService.fetchUser(username);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
