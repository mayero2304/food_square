package com.mciro.food_square.domain.api;

import com.mciro.food_square.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {

    void create(Role role);

    List<Role> list();

    Role getId(Long id);

    void edit(Role user);

    void delete(Long id);

}
