package com.dona.blogDemo.dto;

import jakarta.persistence.Transient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO {
    private Long userId;
    private String names;
    private String email;
    private String role;
    private String address;
}
