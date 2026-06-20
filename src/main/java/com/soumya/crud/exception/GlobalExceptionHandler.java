package com.soumya.crud.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ===== Validation Errors =====
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> 
                        handleValidation(
            MethodArgumentNotValidException ex) {
        
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
          .getFieldErrors()
          .forEach(error -> errors.put(
                error.getField(), 
                error.getDefaultMessage()));
        
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errors);
    }

    // ===== Not Found Errors =====
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> 
                        handleRuntime(RuntimeException ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", ex.getMessage());
        error.put("status", "404");
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }

    // ===== General Errors =====
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> 
                        handleGeneral(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put("error", "Kuch gadbad ho gaya!");
        error.put("details", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(error);
    }
}