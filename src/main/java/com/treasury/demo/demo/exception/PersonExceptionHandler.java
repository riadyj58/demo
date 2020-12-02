
package com.treasury.demo.demo.exception;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class PersonExceptionHandler {


    @ExceptionHandler(value=Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String customBeanValidationHandler(Exception exception)
    {
        StringBuilder sb = new StringBuilder();
        
        List<FieldError> fieldErrors = ((MethodArgumentNotValidException) exception).getBindingResult().getFieldErrors();
        for(FieldError fieldError: fieldErrors){
            sb.append(fieldError.getField()+":"+fieldError.getDefaultMessage());
            sb.append(";");
        }
        log.error("Terjadi Error");
        return sb.toString();
    }

    @ExceptionHandler(value= ValidatorException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String customBeanValidationHandlers(ValidatorException ve)
    {
    
        log.error("Terjadi Error");
        final List<String> errora = new ArrayList<String>();
        
        for (final FieldError error : ve.getBindingResult().getFieldErrors()) 
        {
            if(error.getDefaultMessage() != null && !error.getDefaultMessage().isEmpty())
                errora.add(error.getField() + ": " + error.getDefaultMessage());
            else
                errora.add(error.getField() + ": " + error.getCode());
        }    

        return "error";

    }
}
