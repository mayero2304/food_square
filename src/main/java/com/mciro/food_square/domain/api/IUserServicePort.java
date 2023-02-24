package com.mciro.food_square.domain.api;

import com.mciro.food_square.domain.model.User;

import java.util.List;

public interface IUserServicePort {

    User create(User user);

    List<User> list();

    User getId(Long id);

    void edit(User user);

    void delete(Long id);
}
