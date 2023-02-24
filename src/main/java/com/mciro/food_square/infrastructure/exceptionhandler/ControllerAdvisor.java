package com.mciro.food_square.infrastructure.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> methodArgumentNotValidException(MethodArgumentNotValidException e) {

        BindingResult result = e.getBindingResult();
        Map<String, Object> response = new HashMap<>();

        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
            .stream()
            .map(err -> "El campo '" + err.getField() + "' "+ err.getDefaultMessage())
            .collect(Collectors.toList());
            response.put("errors", errors);
        }
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
    }

    // private static final String MESSAGE = "message";

    // @ExceptionHandler(NoDataFoundException.class)
    // public ResponseEntity<Map<String, String>> handleNoDataFoundException(
    //         NoDataFoundException ignoredNoDataFoundException) {
    //     return ResponseEntity.status(HttpStatus.NOT_FOUND)
    //             .body(Collections.singletonMap(MESSAGE, ExceptionResponse.NO_DATA_FOUND.getMessage()));
    // }

}
