package com.tyss.hrms.exception;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleRescourceNotFoundException(ResourceNotFoundException ex) {
		String message = ex.getMessage();
		ProblemDetail problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
		problemDetail.setType(URI.create("http://localhost:8081/**"));
		problemDetail.setTitle(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problemDetail);
	}
}
