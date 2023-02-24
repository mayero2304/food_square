package com.mciro.food_square.application.mapper;

import com.mciro.food_square.application.dto.response.RoleResponseDto;
import com.mciro.food_square.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleResponseMapper {
    Role toResponse(RoleResponseDto roleResponseDto);

    List<RoleResponseDto> toResponseList(List<Role> roleList);
}
