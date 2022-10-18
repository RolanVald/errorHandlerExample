package com.elRols.app.errorHandler.controller;

import com.elRols.app.errorHandler.exception.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(ArithmeticException.class)
    public String arithmeticError(Exception ex, Model model) {
        model.addAttribute("error", "Arithmetic exception");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/arithmetic";
    }

    @ExceptionHandler(NumberFormatException.class)
    public String numberFormatError(Exception ex, Model model) {
        model.addAttribute("error", "Number Format Exception");
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());

        return "error/numberFormat";
    }

    //Example for a endpoint

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> illegalArgumentException(IllegalArgumentException iae) {
        ExceptionResponse er = new ExceptionResponse(HttpStatus.BAD_REQUEST.value(), iae.getMessage());
        return new ResponseEntity<>(er, HttpStatus.BAD_REQUEST);
    }
}
