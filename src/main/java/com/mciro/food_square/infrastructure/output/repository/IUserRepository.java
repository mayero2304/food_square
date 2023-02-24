package com.mciro.food_square.infrastructure.output.repository;

import com.mciro.food_square.infrastructure.output.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    
}
