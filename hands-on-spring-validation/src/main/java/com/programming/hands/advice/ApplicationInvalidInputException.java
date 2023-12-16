package com.programming.hands.advice;

import com.programming.hands.exception.NotStudentFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationInvalidInputException {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> invalidInputExceptionHandler(MethodArgumentNotValidException ex) {

        Map<String, String> map = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(
                err -> map.put(err.getField(), err.getDefaultMessage())
        );
        return map;
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NotStudentFoundException.class)
    public Map<String, String> notStudentFoundExceptionHandler(NotStudentFoundException ex) {
        var map = new HashMap<String, String>();
        map.put("errorMessage", ex.getMessage());
        return map;
    }
}
