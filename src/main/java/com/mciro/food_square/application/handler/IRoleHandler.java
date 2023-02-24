package com.mciro.food_square.application.handler;

import com.mciro.food_square.application.dto.request.RoleRequestDto;
import com.mciro.food_square.application.dto.response.RoleResponseDto;

import java.util.List;

public interface IRoleHandler {
    void create(RoleRequestDto roleRequestDto);

    List<RoleResponseDto> list();
}
