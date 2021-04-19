package com.football.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity handleEntityNotFoundEx(EntityNotFoundException e) {
        ApiError apiError = new ApiError("Entity not found Exception ", e.getMessage());
        return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiError apiError = new ApiError("Incorrect JSON Request", ex.getMessage());
        return new ResponseEntity(apiError, status);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        ApiError apiError = new ApiError("Method Argument Not Valid", ex.getMessage(), errors);
        return new ResponseEntity<>(apiError, status);
    }
}
