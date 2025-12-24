package com.ToList.management.Exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalHandle {
    private final Logger logger = LoggerFactory.getLogger(GlobalHandle.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuch){
        String mensage = "Task not found";
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(mensage);

    }
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> handleUnexpectedExeption(Throwable unexpectedExeption){
        String message = "Unexpected server error, see the logs";
        logger.error("Unexpected error", unexpectedExeption);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(message);
    }


}
