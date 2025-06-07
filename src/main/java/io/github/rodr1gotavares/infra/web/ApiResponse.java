package io.github.rodr1gotavares.infra.web;


import java.time.Instant;

import org.springframework.http.HttpStatus;

public record ApiResponse<T>(
	    Instant timestamp,
	    int status,
	    String error,
	    String message,
	    T data
	) {
	    public static <T> ApiResponse<T> ok(HttpStatus status, T data) {
	        return new ApiResponse<>(
	            Instant.now(),
	            status.value(),
	            status.getReasonPhrase(),
	            "Success",
	            data
	        );
	    }

	    public static ApiResponse<Void> error(HttpStatus status, String message) {
	    	return new ApiResponse<>(
		            Instant.now(),
		            status.value(),
		            status.getReasonPhrase(),
		            message,
		            null
		        );
	    }
	    
	}