package com.mciro.food_square.domain.usecase;

import com.mciro.food_square.domain.api.IUserServicePort;
import com.mciro.food_square.domain.model.User;
import com.mciro.food_square.domain.spi.IUserPersistencePort;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public User create(User user) {
        return userPersistencePort.create(user);
    }

    @Override
    public List<User> list() {
        return userPersistencePort.list();
    }

    @Override
    public User getId(Long id) {
        return userPersistencePort.getId(id);
    }

    @Override
    public void edit(User user) {
        userPersistencePort.edit(user);
    }

    @Override
    public void delete(Long id) {
        userPersistencePort.delete(id);
    }
}
