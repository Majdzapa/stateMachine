package com.state.machine.lifecycle.config;

import com.state.machine.lifecycle.exception.ErrorObject;
import com.state.machine.lifecycle.exception.FinalStateException;
import com.state.machine.lifecycle.exception.NotFoundStateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalConfig {

    @ExceptionHandler(FinalStateException.class)
    public ResponseEntity<ErrorObject> handleFinalStateException(FinalStateException ex){

        ErrorObject errObj = ErrorObject.builder()
                .title("Final Stata is Reached")
                .description(ex.getMessage())
                .build();

        return new ResponseEntity<ErrorObject>(errObj, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(NotFoundStateException.class)
    public ResponseEntity<ErrorObject> handleFinalStateException(NotFoundStateException ex){

        ErrorObject errObj = ErrorObject.builder()
                .title("Given State and event does not matched")
                .description(ex.getMessage())
                .build();

        return new ResponseEntity<ErrorObject>(errObj, HttpStatus.CONFLICT);
    }
}
