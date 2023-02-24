package com.mciro.food_square.infrastructure.output.adapter;

import java.util.List;

import com.mciro.food_square.domain.model.Role;
import com.mciro.food_square.domain.spi.IRolePersistencePort;
import com.mciro.food_square.infrastructure.exception.NoDataFoundException;
import com.mciro.food_square.infrastructure.output.entity.RoleEntity;
import com.mciro.food_square.infrastructure.output.mapper.IRoleEntityMapper;
import com.mciro.food_square.infrastructure.output.repository.IRoleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public void create(Role role) {
        RoleEntity roleEntity = roleRepository.save(roleEntityMapper.toEntity(role));
        roleEntityMapper.toRole(roleEntity);
    }

    @Override
    public List<Role> list() {
        List<RoleEntity> entityList = roleRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return roleEntityMapper.toRoleList(entityList);
    }
}
