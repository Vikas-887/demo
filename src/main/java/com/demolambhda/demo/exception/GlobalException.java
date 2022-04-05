package com.demolambhda.demo.exception;

import java.util.Date;

import org.springframework.boot.context.config.ConfigDataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {

    //  Handle Global Exception of any type other than defined.
@ExceptionHandler(Exception.class)
public ResponseEntity<?> golbalExceptionHandler(Exception exception,WebRequest request ){
    ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(),
                                     new Date(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.OK);
}


@ExceptionHandler(ConfigDataNotFoundException.class)
public ResponseEntity<?> handleConfigDataNotFoundException(ConfigDataNotFound exception,WebRequest request) {
    ErrorDetails errorDetails=new ErrorDetails(exception.getMessage(),
                                     new Date(), request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.OK);

    
}
}