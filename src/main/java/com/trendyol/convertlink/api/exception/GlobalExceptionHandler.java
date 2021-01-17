package com.trendyol.convertlink.api.exception;


import com.trendyol.convertlink.domain.shared.DomainException;
import com.trendyol.convertlink.domain.shared.ExceptionDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(Exception ex) {
        logger.error("Error: ", ex);
        return new ResponseEntity<Object>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity handleDomainException(Exception ex) {
        ExceptionDetail exDetail = AnnotationUtils.findAnnotation(ex.getClass(), ExceptionDetail.class);
        logger.error("Error: ", ex);
        return new ResponseEntity<Object>(ex, HttpStatus.valueOf(exDetail.responseCode()));
    }
}

