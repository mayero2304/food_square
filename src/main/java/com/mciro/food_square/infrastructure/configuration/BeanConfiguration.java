package com.mciro.food_square.infrastructure.configuration;

import com.mciro.food_square.domain.api.IRoleServicePort;
import com.mciro.food_square.domain.api.IUserServicePort;
import com.mciro.food_square.domain.spi.IRolePersistencePort;
import com.mciro.food_square.domain.spi.IUserPersistencePort;
import com.mciro.food_square.domain.usecase.RoleUseCase;
import lombok.RequiredArgsConstructor;
import com.mciro.food_square.domain.usecase.UserUseCase;
import com.mciro.food_square.infrastructure.output.adapter.RoleJpaAdapter;
import com.mciro.food_square.infrastructure.output.adapter.UserJpaAdapter;
import com.mciro.food_square.infrastructure.output.mapper.IRoleEntityMapper;
import com.mciro.food_square.infrastructure.output.mapper.IUserEntityMapper;
import com.mciro.food_square.infrastructure.output.repository.IRoleRepository;
import com.mciro.food_square.infrastructure.output.repository.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;

    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Bean
    public IUserPersistencePort userPersistencePort(){
        return new UserJpaAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort(){
        return new RoleJpaAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
