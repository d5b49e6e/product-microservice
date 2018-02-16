/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample.microservice.productservice.exception;

import com.sample.microservice.productservice.product.ProductCreateException;
import com.sample.microservice.productservice.product.ProductEmptyListException;
import com.sample.microservice.productservice.product.ProductNotFoundException;
import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Francis
 */
@ControllerAdvice //share across multiple controllers
@RestController
public class CustomResponseEnityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex
            , HttpHeaders hh
            , HttpStatus hs
            , WebRequest wr
    ) {
        
        FieldError fieldError = ex.getBindingResult().getFieldError("defaultMessage");
        
        ExceptionResponse er = new ExceptionResponse(        
                new Date()
                ,"Validation Failed"
                ,fieldError.getDefaultMessage()
                
        );        
        return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
    }

    
    
    
    
    
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest wr) {
        
        ExceptionResponse er = new ExceptionResponse(        
                new Date()
                ,ex.getMessage()
                ,wr.getDescription(false)
                
        );        
        return new ResponseEntity(er,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    
    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(ProductNotFoundException ex, WebRequest wr) {
        
        ExceptionResponse er = new ExceptionResponse(        
                new Date()
                ,ex.getMessage()
                ,wr.getDescription(false)
                
        );        
        return new ResponseEntity(er,HttpStatus.NOT_FOUND);
    }
    
    
    @ExceptionHandler(ProductEmptyListException.class)
    public final ResponseEntity<Object> handleUserEmptyListException            
            (ProductEmptyListException ex, WebRequest wr) {
        
        ExceptionResponse er = new ExceptionResponse(        
                new Date()
                ,ex.getMessage()
                ,wr.getDescription(false)
                
        );        
        return new ResponseEntity(er,HttpStatus.NO_CONTENT);
    }
    
    @ExceptionHandler(ProductCreateException.class)
    public final ResponseEntity<Object> handleUserCreateException
            (ProductCreateException ex, WebRequest wr) {
        
        ExceptionResponse er = new ExceptionResponse(        
                new Date()
                ,ex.getMessage()
                ,wr.getDescription(false)
                
        );        
        return new ResponseEntity(er,HttpStatus.NOT_ACCEPTABLE);
    }
  
    
    
       
}
