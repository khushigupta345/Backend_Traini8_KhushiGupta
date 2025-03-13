package com.example.execption;



import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // used to handle custom exception
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(ResourceNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("message", ex.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.NOT_FOUND);
    }

    //  // used to handle invailed data exception
    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<Map<String, String>> handleInvalidData(InvalidDataException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("error", ex.getMessage());
        return new ResponseEntity<>(errorMap, HttpStatus.BAD_REQUEST);
    }

     // used to handle validation error
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

   
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataConflict(DataIntegrityViolationException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "database error: " + ex.getMostSpecificCause().getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    // when json format is wrong
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleInvalidFormat(HttpMessageNotReadableException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "json format wrong: " + ex.getMostSpecificCause().getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // for general exeception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleUnknownError(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "something went wrng: " + ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}