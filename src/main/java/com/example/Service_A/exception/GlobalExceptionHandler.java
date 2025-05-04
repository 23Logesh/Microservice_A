package com.example.Service_A.exception;

import com.example.Service_A.utility.ResponseStructure;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientResponseException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseStructure> handleNullPointerException(NullPointerException e) {
        ResponseStructure response = new ResponseStructure();
        response.setMessage("NullPointerException occurred");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({org.springframework.web.client.HttpClientErrorException.class, HttpServerErrorException.class})
    public ResponseEntity<ResponseStructure> handleHttpClientErrorException(RestClientResponseException e) {
        ResponseStructure response = new ResponseStructure();
        response.setMessage("URL Incorrect");
        response.setStatus(HttpStatus.BAD_GATEWAY.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseStructure> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        ResponseStructure response = new ResponseStructure();
        response.setMessage("Data integrity violation");
        response.setStatus(HttpStatus.CONFLICT.value());
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseStructure> handleConstraintViolationException(ConstraintViolationException e) {
        ResponseStructure response = new ResponseStructure();
        response.setMessage("Invalid data passed");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
