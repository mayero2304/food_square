package com.mciro.food_square.application.handler.impl;

import com.mciro.food_square.application.dto.request.RoleRequestDto;
import com.mciro.food_square.application.dto.response.RoleResponseDto;
import com.mciro.food_square.application.handler.IRoleHandler;
import com.mciro.food_square.application.mapper.IRoleRequestMapper;
import com.mciro.food_square.application.mapper.IRoleResponseMapper;
import com.mciro.food_square.domain.api.IRoleServicePort;
import com.mciro.food_square.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler {

    private final IRoleServicePort roleServicePort;
    private final IRoleResponseMapper roleResponseMapper;
    private final IRoleRequestMapper roleRequestMapper;

    @Override
    public void create(RoleRequestDto roleRequestDto) {
        Role role = roleRequestMapper.toObject(roleRequestDto);
        roleServicePort.create(role);
    }

    @Override
    public List<RoleResponseDto> list() {
        return roleResponseMapper.toResponseList(roleServicePort.list());
    }
}
