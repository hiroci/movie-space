package com.jiriao.jiriaomovie.controller.exception;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = PSQLException.class)
    public ResponseEntity<Object> handleSqlException(PSQLException psqlException){
        return new ResponseEntity<>(psqlException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
