package io.github.rodr1gotavares.infra.web;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.reactive.resource.NoResourceFoundException;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private ResponseEntity<ApiResponseFactory<Void>> buildErrorResponse(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(ApiResponseFactory.error(status, message));
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ApiResponseFactory<Void>> handleAccessDeniedException(AccessDeniedException ex) {
        logger.error("Access denied: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, "Access denied");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponseFactory<Void>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        logger.error("Invalid method argument: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Invalid arguments.");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponseFactory<Void>> handleNoSuchElementException(NoSuchElementException ex) {
        logger.error("Element not found: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.NOT_FOUND, "Element not found");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<ApiResponseFactory<Void>> handleNoResourceFoundException(NoResourceFoundException ex) {
        logger.error("No resource found: {}", ex.getMessage());
        return buildErrorResponse(HttpStatus.NOT_FOUND, "No resource found");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponseFactory<Void>> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.error("IllegalArgumentException", ex);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Illegal arguments");
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity<ApiResponseFactory<Void>> handleIoException(IOException ex) {
        logger.error("IOException", ex);
        return buildErrorResponse(HttpStatus.BAD_REQUEST, "Failed to receive image file.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseFactory<Void>> handleGenericException(Exception ex) {
        logger.error("Unexpected exception", ex);
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");
    }
}
