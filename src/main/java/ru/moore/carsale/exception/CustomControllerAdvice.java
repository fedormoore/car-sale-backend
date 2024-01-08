package ru.moore.carsale.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleConstraintViolation(ConstraintViolationException ex) {
        StringBuilder errors = new StringBuilder();

        for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
            if (errors.isEmpty()) {
                errors.append(constraintViolation.getMessage());
            } else {
                errors.append(" ").append(constraintViolation.getMessage());
            }
        }
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, errors.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        StringBuilder errors = new StringBuilder();

        for (FieldError constraintViolation : ex.getBindingResult().getFieldErrors()) {
            if (errors.isEmpty()) {
                errors.append(constraintViolation.getDefaultMessage());
            } else {
                errors.append(" ").append(constraintViolation.getDefaultMessage());
            }
        }
        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, errors.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<?> handleUserNotFoundException(ErrorTemplate ex) {
        ErrorResponse error = new ErrorResponse(ex.getStatus(), ex.getMessage());
        return new ResponseEntity(error, ex.getStatus());
    }

}
