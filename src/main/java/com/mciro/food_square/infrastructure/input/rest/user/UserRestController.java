package com.mciro.food_square.infrastructure.input.rest.user;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mciro.food_square.application.dto.request.UserRequestDto;
import com.mciro.food_square.application.dto.response.UserResponseDto;
import com.mciro.food_square.application.handler.IUserHandler;
import com.mciro.food_square.domain.model.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserRestController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    private final IUserHandler userHandler;

    @Operation(summary = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Object created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Object already exists", content = @Content)
    })
    @PostMapping({ "/", "" })
    public ResponseEntity<?> create(@Valid @RequestBody UserRequestDto userRequestDto) {
        String passEncrypt = passwordEncoder.encode(userRequestDto.getPassword());
        userRequestDto.setPassword(passEncrypt);
        User user = userHandler.create(userRequestDto);
        System.out.println(user);
        return ResponseEntity.ok(user);
    }

    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All objects returned", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = UserResponseDto.class)))),
            @ApiResponse(responseCode = "404", description = "No data found", content = @Content)
    })
    @GetMapping("/")
    public ResponseEntity<List<UserResponseDto>> list() {
        return ResponseEntity.ok(userHandler.list());
    }

    @GetMapping("/edit/{id}")
    public ResponseEntity<User> show(@PathVariable Long id) {
        System.out.println(id);
        return ResponseEntity.ok(userHandler.getId(id));
    }
}
