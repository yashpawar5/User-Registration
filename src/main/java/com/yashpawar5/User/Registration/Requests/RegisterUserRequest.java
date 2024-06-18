package com.yashpawar5.User.Registration.Requests;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String userName;
    private String password;
    private String email;
}
