package com.mciro.food_square.domain.spi;

import com.mciro.food_square.domain.model.User;

import java.util.List;

public interface IUserPersistencePort {

    User create(User user);

    List<User> list();

    void edit(User user);

    void delete(Long id);

    User getId(Long id);
}
