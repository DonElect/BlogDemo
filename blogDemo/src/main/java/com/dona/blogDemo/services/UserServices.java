package com.dona.blogDemo.services;

import com.dona.blogDemo.dto.LoginDTO;
import com.dona.blogDemo.dto.SignupDTO;
import com.dona.blogDemo.dto.UserResponseDTO;

public interface UserServices {
    UserResponseDTO registerNewUser(SignupDTO signupDTO);
    UserResponseDTO loginUser(LoginDTO loginDTO);
    void deleteUser(Long userId);
}
