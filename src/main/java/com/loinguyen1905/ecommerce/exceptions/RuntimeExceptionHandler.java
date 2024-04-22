package com.loinguyen1905.ecommerce.exceptions;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.aot.hint.annotation.Reflective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.MethodNotAllowed;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.loinguyen1905.ecommerce.core.interceptor.RestTemplateFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.apache.coyote.BadRequestException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;

@Order(Ordered.HIGHEST_PRECEDENCE)
// @ControllerAdvice
@SuppressWarnings("rawtypes")
public class RuntimeExceptionHandler extends RuntimeException{
    private static final Logger LOGGER = LoggerFactory.getLogger(RestTemplateFilter.class);
    private static final Map<Class<? extends Exception>, Integer> exceptionStatusMap = new HashMap();

    static {
        exceptionStatusMap.put(NotFoundException.class, 404);
        exceptionStatusMap.put(Unauthorized.class, 401);
    }

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object logRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        LOGGER.info("Request: {} {}", request.getMethod(), request.getRequestURI());
        Object result = joinPoint.proceed();
        LOGGER.info("Response: {}", response.getStatus());
        return result;
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<EcommerceCustomException> badRequestException(BadRequestException ex, WebRequest request) {
        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.BAD_REQUEST.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<EcommerceCustomException> handleNoResourceFoundException(NoResourceFoundException ex, WebRequest request) {
        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.NOT_FOUND.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler( HttpRequestMethodNotSupportedException.class )
    public ResponseEntity<EcommerceCustomException> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex, WebRequest request) {

        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.METHOD_NOT_ALLOWED.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.METHOD_NOT_ALLOWED
        );
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<EcommerceCustomException> handleAccessDeniedException(AccessDeniedException ex) {

        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.FORBIDDEN.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.FORBIDDEN
        );
    }

    @ExceptionHandler({ IllegalArgumentException.class, IllegalStateException.class })
    public ResponseEntity<EcommerceCustomException> handleConflict(RuntimeException ex, WebRequest request) {

        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.CONFLICT.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<EcommerceCustomException> handlerEntityNotFound(NoHandlerFoundException ex) {

        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.NOT_FOUND.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Unauthorized.class)
    public ResponseEntity<EcommerceCustomException> handlerUnauthorized(Unauthorized ex) {

        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.CONFLICT.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.CONFLICT
        );
    }

    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<EcommerceCustomException> handlerInternalServerError(InternalServerError ex) {

        return new ResponseEntity<EcommerceCustomException>(
            new EcommerceCustomException.EcommerceCustomExceptionBuilder()
            .withStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .withMessage(ex.getMessage())
            .withDescription(ex.getClass().getSimpleName())
            .withTimestamp(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime())).build()
            , HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}