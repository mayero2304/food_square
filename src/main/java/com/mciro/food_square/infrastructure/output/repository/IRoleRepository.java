package com.mciro.food_square.infrastructure.output.repository;

import com.mciro.food_square.infrastructure.output.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {
}
