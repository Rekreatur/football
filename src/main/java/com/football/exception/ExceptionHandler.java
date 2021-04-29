package com.football.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(MatchException.class)
    public ResponseEntity teamNotGame(MatchException ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity handleEntityNotFoundEx(EntityNotFoundException e) {
        ApiResponseException apiResponse = new ApiResponseException("Entity not found Exception ", e.getMessage());
        return new ResponseEntity(apiResponse, HttpStatus.NOT_FOUND);
    }


    @org.springframework.web.bind.annotation.ExceptionHandler({MethodArgumentTypeMismatchException.class})
    protected ResponseEntity handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex, HttpStatus status,
                                                              WebRequest request) {
        ApiResponseException apiResponse = new ApiResponseException();
        apiResponse.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
                ex.getName(), ex.getValue(), Objects.requireNonNull(ex.getRequiredType()).getSimpleName()));
        apiResponse.setDebugMessage(ex.getMessage());
        return new ResponseEntity(apiResponse, status);
    }

    @Override
    protected ResponseEntity handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        ApiResponseException apiResponse = new ApiResponseException("Incorrect JSON Request", ex.getMessage());
        return new ResponseEntity(apiResponse, status);
    }

    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                          HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        ApiResponseException apiResponse = new ApiResponseException("Method Argument Not Valid", ex.getMessage(), errors);
        return new ResponseEntity(apiResponse, status);
    }

    @Override
    protected ResponseEntity handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
                                                           HttpStatus status, WebRequest request) {
        return new ResponseEntity(new ApiResponseException("No Handler Found", ex.getMessage()), status);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    protected ResponseEntity handleException(Exception ex, HttpStatus status) {
        return new ResponseEntity(new ApiResponseException("Exception", ex.getMessage()), status);
    }
}
