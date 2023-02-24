package com.mciro.food_square.application.dto.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    // private Long id;
    private String name;
    private String lastname;
    private Integer nit;
    private String phone;
    private String email;
    private Long role_id;
}
