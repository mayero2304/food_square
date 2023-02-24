package com.mciro.food_square.application.mapper;

import com.mciro.food_square.application.dto.request.RoleRequestDto;
import com.mciro.food_square.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleRequestMapper {
    Role toObject(RoleRequestDto roleRequestDto);
}
