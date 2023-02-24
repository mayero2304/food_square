package com.mciro.food_square.infrastructure.output.mapper;

import com.mciro.food_square.domain.model.User;
import com.mciro.food_square.infrastructure.output.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    @Mapping(source = "role_id", target = "role.id")
    UserEntity toEntity(User user); // Model to Entity

    @Mapping(source = "role.id", target = "role_id")
    User toUser(UserEntity userEntity); // Entity to Model

    List<User> toUserList(List<UserEntity> userEntityList); // Entity to Model
}
