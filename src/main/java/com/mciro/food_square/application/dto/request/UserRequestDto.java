package com.mciro.food_square.application.dto.request;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {
    @NotBlank(message = "is required")
    @NotNull(message = "not null")
    private String name;

    @NotBlank(message = "is required")
    @NotNull(message = "not null")
    private String lastname;

    @NotNull(message = "not null")
    private Integer nit;

    @NotBlank(message = "is required")
    @NotNull(message = "not null")
    @Pattern(regexp = "[+]?[0-9]{12}", message = "es invalid Example: +573005698325")
    private String phone;

    @NotBlank(message = "is required")
    @NotNull(message = "not null")
    @Email
    private String email;

    @NotBlank(message = "is required")
    @NotNull(message = "not null")
    private String password;

    @NotNull(message = "not null")
    private Long role_id;
}
