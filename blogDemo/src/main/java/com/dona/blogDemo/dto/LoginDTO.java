package com.dona.blogDemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {
    @NotBlank(message = "*required")
    @Size(min = 10, max = 25)
    private String email;

    @NotBlank(message = "*required")
    @Size(min = 4, max = 15)
    private String password;
}
