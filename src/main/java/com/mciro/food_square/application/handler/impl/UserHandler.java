package com.mciro.food_square.application.handler.impl;

import com.mciro.food_square.application.dto.request.UserRequestDto;
import com.mciro.food_square.application.dto.response.UserResponseDto;
import com.mciro.food_square.application.handler.IUserHandler;
import com.mciro.food_square.application.mapper.IUserRequestMapper;
import com.mciro.food_square.application.mapper.IUserResponseMapper;
import com.mciro.food_square.domain.api.IUserServicePort;
import com.mciro.food_square.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {

    private final IUserServicePort userServicePort;
    private final IUserResponseMapper userResponseMapper;
    private final IUserRequestMapper userRequestMapper;


    @Override
    public User create(UserRequestDto userRequestDto) {
        User user = userRequestMapper.toObject(userRequestDto);
        return userServicePort.create(user);
    }

    @Override
    public List<UserResponseDto> list() {
        return userResponseMapper.toResponseList(userServicePort.list());
    }

    @Override
    public User getId(Long id) {
        return null;
    }

    @Override
    public void edit(UserResponseDto userResponseDto) {

    }

    @Override
    public void delete(UserResponseDto userResponseDto) {

    }
}
