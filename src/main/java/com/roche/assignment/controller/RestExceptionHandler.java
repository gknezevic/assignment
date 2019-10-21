package com.roche.assignment.controller;

import com.roche.assignment.model.exceptions.ProductNotFoundException;
import com.roche.assignment.model.exceptions.ProductSavingException;
import com.roche.assignment.model.exceptions.RequiredFieldEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ProductNotFoundException.class)
    public void handleProductNotFound(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(value = ProductSavingException.class)
    public void handleProductSavingException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(value = RequiredFieldEmptyException.class)
    public void handleRequiredFieldEmptyException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }

}
