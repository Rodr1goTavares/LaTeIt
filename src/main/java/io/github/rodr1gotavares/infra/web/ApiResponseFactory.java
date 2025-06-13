package io.github.rodr1gotavares.infra.web;


import java.time.Instant;

import org.springframework.http.HttpStatus;

/**
 * @author Rodr1goTavares - <a href="https://github.com/Rodr1goTavares">GitHub</a>
 */
public record ApiResponseFactory<T>(
	    Instant timestamp,
	    int status,
	    String error,
	    String message,
	    T data
	) {
	    public static <T> ApiResponseFactory<T> ok(HttpStatus status, T data) {
	        return new ApiResponseFactory<>(
	            Instant.now(),
	            status.value(),
	            status.getReasonPhrase(),
	            "Success",
	            data
	        );
	    }

	    public static ApiResponseFactory<Void> error(HttpStatus status, String message) {
	    	return new ApiResponseFactory<>(
		            Instant.now(),
		            status.value(),
		            status.getReasonPhrase(),
		            message,
		            null
		        );
	    }
	    
	}