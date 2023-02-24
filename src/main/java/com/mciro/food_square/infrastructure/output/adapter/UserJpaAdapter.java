package com.mciro.food_square.infrastructure.output.adapter;

import com.mciro.food_square.domain.model.User;
import com.mciro.food_square.domain.spi.IUserPersistencePort;
import com.mciro.food_square.infrastructure.exception.NoDataFoundException;
import com.mciro.food_square.infrastructure.output.entity.UserEntity;
import com.mciro.food_square.infrastructure.output.mapper.IUserEntityMapper;
import com.mciro.food_square.infrastructure.output.repository.IUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequiredArgsConstructor
@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class UserJpaAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    @Override
    public User create(User user) {
        UserEntity userEntity = userRepository.save(userEntityMapper.toEntity(user));
        return userEntityMapper.toUser(userEntity);
    }

    @Override
    public List<User> list() {
        List<UserEntity> entityList = userRepository.findAll();
        if (entityList.isEmpty()) {
            throw new NoDataFoundException();
        }
        return userEntityMapper.toUserList(entityList);
    }


    @Override
    public void edit(User user) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User getId(Long id) {
        return null;
    }
}
