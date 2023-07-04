package com.example.reservation.common;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({
			BadCredentialsException.class,
			UsernameNotFoundException.class,
			InsufficientAuthenticationException.class
	})
	public ResponseEntity<ErrorResponse> unAuthorizedExceptionHandler(HttpServletRequest request, Exception e) {
		printException(e);
		return new ResponseEntity<>(
				ErrorResponse.of(e.getMessage(), request.getRequestURI()),
				HttpStatus.UNAUTHORIZED
		);
	}

	@ExceptionHandler({IllegalArgumentException.class, EntityNotFoundException.class})
	public ResponseEntity<ErrorResponse> badRequestExceptionHandler(HttpServletRequest request, Exception e) {
		printException(e);
		return new ResponseEntity<>(
				ErrorResponse.of(e.getMessage(), request.getRequestURI()),
				HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(HttpServletRequest request,
			MethodArgumentNotValidException e) {
		printException(e);
		List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

		StringBuilder errorMessage = new StringBuilder();
		errorMessage.append("validation failed fields: [ ");

		int size = fieldErrors.size();
		for (int i = 0; i < size; i++) {
			errorMessage.append(fieldErrors.get(i).getField());
			if (i == size - 1) {
				continue;
			}
			errorMessage.append(", ");
		}
		errorMessage.append(" ]");

		return new ResponseEntity<>(
				ErrorResponse.of(errorMessage.toString(), request.getRequestURI(), fieldErrors),
				HttpStatus.BAD_REQUEST
		);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> runtimeExceptionHandler(HttpServletRequest request, RuntimeException e) {
		printException(e);
		return new ResponseEntity<>(
				ErrorResponse.of(e.getMessage(), request.getRequestURI()),
				HttpStatus.INTERNAL_SERVER_ERROR
		);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(HttpServletRequest request, Exception e) {
		printException(e);
		return new ResponseEntity<>(
				ErrorResponse.of(e.getMessage(), request.getRequestURI()),
				HttpStatus.INTERNAL_SERVER_ERROR
		);
	}

	private void printException(Exception e) {
		log.info("{}", e.toString());
	}
}
