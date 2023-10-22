package com.dona.blogDemo.rest;

import com.dona.blogDemo.dto.LoginDTO;
import com.dona.blogDemo.dto.SignupDTO;
import com.dona.blogDemo.dto.UserResponseDTO;
import com.dona.blogDemo.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class LoginAndSignupController {
    private final UserServices services;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody SignupDTO signupDTO){
        return ResponseEntity.ok(services.registerNewUser(signupDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> loginUser(@RequestBody LoginDTO loginDTO){
        return ResponseEntity.ok(services.loginUser(loginDTO));
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> removeUser(@PathVariable Long userId){
        services.deleteUser(userId);
        return ResponseEntity.ok("User with ID: "+userId+" deleted.");
    }
}
