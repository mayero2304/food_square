package com.mciro.food_square.domain.usecase;

import com.mciro.food_square.domain.api.IRoleServicePort;
import com.mciro.food_square.domain.model.Role;
import com.mciro.food_square.domain.spi.IRolePersistencePort;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void create(Role role) {
         rolePersistencePort.create(role);
    }

    @Override
    public List<Role> list() {
        return rolePersistencePort.list();
    }

    @Override
    public Role getId(Long id) {
        return null;
    }

    @Override
    public void edit(Role user) {

    }

    @Override
    public void delete(Long id) {

    }
}
