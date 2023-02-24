package com.mciro.food_square.infrastructure.input.rest.role;

import com.mciro.food_square.application.dto.request.RoleRequestDto;
import com.mciro.food_square.application.dto.response.RoleResponseDto;
import com.mciro.food_square.application.handler.IRoleHandler;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleRestController {

    private final IRoleHandler roleHandler;

    @Operation(summary = "Add a new role")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Role created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Role already exists", content = @Content)
    })
    @PostMapping("/")
    public ResponseEntity<Void> create(@RequestBody RoleRequestDto roleRequestDto) {
        roleHandler.create(roleRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<RoleResponseDto>> list() {
        return ResponseEntity.ok(roleHandler.list());
    }
}
