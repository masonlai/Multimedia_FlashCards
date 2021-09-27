package com.masonlai.FlashCards.Exception;

import org.springframework.data.rest.core.RepositoryConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.sqlite.SQLiteException;

@ControllerAdvice
public class ValidatorExceptionHandler {

    @ExceptionHandler(RepositoryConstraintViolationException.class)
    public ResponseEntity handleJPAValidatorException(RepositoryConstraintViolationException e)  {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getErrors().getFieldError().getCode());

    }

    @ExceptionHandler(SQLiteException.class)
    public ResponseEntity handleSQLiteExceptionException(SQLiteException e)  {
        //Handle constraint violation
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

    }


}