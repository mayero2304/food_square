package com.mciro.food_square.domain.spi;

import com.mciro.food_square.domain.model.Role;

import java.util.List;

public interface IRolePersistencePort {

    void create(Role role);

    List<Role> list();
}
