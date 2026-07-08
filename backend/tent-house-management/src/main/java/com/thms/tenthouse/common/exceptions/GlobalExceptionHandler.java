package com.thms.tenthouse.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>>
    handleValidationExceptions(
        MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult()
            .getFieldErrors()
            .forEach(error ->
                errors.put(
                    error.getField(),
                    error.getDefaultMessage()));

        return new ResponseEntity<>(
            errors,
            HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<String>
    handleCustomerAlreadyExistsException(
        CustomerAlreadyExistsException ex) {

        return new ResponseEntity<>(
            ex.getMessage(),
            HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String>
    handleCustomerNotFoundException(
        CustomerNotFoundException ex) {

        return new ResponseEntity<>(
            ex.getMessage(),
            HttpStatus.NOT_FOUND);
    }
}
