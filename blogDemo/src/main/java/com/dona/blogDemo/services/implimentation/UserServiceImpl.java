package com.dona.blogDemo.services.implimentation;

import com.dona.blogDemo.dto.LoginDTO;
import com.dona.blogDemo.dto.SignupDTO;
import com.dona.blogDemo.dto.UserResponseDTO;
import com.dona.blogDemo.model.entity.UsersEntity;
import com.dona.blogDemo.exception.DuplicateEmailException;
import com.dona.blogDemo.exception.PasswordMismatchException;
import com.dona.blogDemo.exception.WrongDetailsException;
import com.dona.blogDemo.repository.UserRepository;
import com.dona.blogDemo.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserServices {

    private final UserRepository userRepo;
    private final ModelMapper mapper = new ModelMapper();
    @Override
    public UserResponseDTO registerNewUser(SignupDTO signupDTO) {
        if (userRepo.existsByEmail(signupDTO.getEmail())){
            throw new DuplicateEmailException("Email already exist!");
        }

        if (!signupDTO.getPassword().equals(signupDTO.getConfirmPassword())){
            throw new PasswordMismatchException("Check password and try again.");
        }

        UsersEntity newUser = mapper.map(signupDTO, UsersEntity.class);

        newUser.setRole("USER");

        UsersEntity savedUser = userRepo.save(newUser);

//        UserResponseDTO responseDTO = mapper.map(savedUser, UserResponseDTO.class);
//
//        return responseDTO;
        return mapper.map(savedUser, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO loginUser(LoginDTO loginDTO) {
        UsersEntity user = userRepo
                .findUsersEntityByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword())
                .orElseThrow(() -> new WrongDetailsException("Email or password incorrect!"));

        return mapper.map(user, UserResponseDTO.class);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }
}
