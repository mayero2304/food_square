package com.mciro.food_square.application.mapper;

import com.mciro.food_square.application.dto.request.UserRequestDto;
import com.mciro.food_square.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    User toObject(UserRequestDto userRequestDto);
}
