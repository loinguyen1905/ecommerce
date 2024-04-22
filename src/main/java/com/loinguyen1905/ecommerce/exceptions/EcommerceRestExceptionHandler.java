package com.loinguyen1905.ecommerce.exceptions;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import jakarta.servlet.http.HttpServletResponse;

@Order(Ordered.LOWEST_PRECEDENCE)
// @ControllerAdvice
public class EcommerceRestExceptionHandler {
  
  @ExceptionHandler(Exception.class)
  public ResponseEntity<EcommerceCustomException> resourceNotFoundException(Exception ex, WebRequest request, HttpServletResponse response)  {
    return new ResponseEntity<EcommerceCustomException>(
        new EcommerceCustomException.EcommerceCustomExceptionBuilder()
        .withStatusCode(HttpStatus.BAD_REQUEST.value())
        .withMessage(ex.getMessage())
        .withDescription(ex.getClass().getSimpleName())
        .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
        , HttpStatus.BAD_REQUEST
    );
  }
}