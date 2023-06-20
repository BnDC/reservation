package com.example.reservation.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({BadCredentialsException.class, UsernameNotFoundException.class})
	public ResponseEntity<String> unAuthorizedExceptionHandler(Exception e) {
		log.info("BadCredentialsException handled message= {}", e.getMessage());
		return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> illegalArgumentExceptionHandler(IllegalArgumentException e) {
		log.info("IllegalArgumentException handled message= {}", e.getMessage());
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> runtimeExceptionHandler(RuntimeException e) {
		log.info("RuntimeException handled message= {}", e.getMessage());
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception e) {
		log.info("Exception handled message= {}", e.getMessage());
		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
