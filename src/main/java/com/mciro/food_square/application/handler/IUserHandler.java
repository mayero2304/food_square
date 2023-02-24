package com.mciro.food_square.application.handler;

import com.mciro.food_square.application.dto.request.UserRequestDto;
import com.mciro.food_square.application.dto.response.UserResponseDto;
import com.mciro.food_square.domain.model.User;

import java.util.List;

public interface IUserHandler {

    User create(UserRequestDto userRequestDto);

    List<UserResponseDto> list();

    User getId(Long id);

    void edit(UserResponseDto userResponseDto);

    void delete(UserResponseDto userResponseDto);
}
