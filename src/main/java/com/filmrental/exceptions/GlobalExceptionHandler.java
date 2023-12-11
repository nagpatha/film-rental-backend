package com.filmrental.exceptions;

import java.net.http.HttpHeaders;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
	public class GlobalExceptionHandler {
	 
	    @ExceptionHandler({ActorNotFoundException.class })
	    public ResponseEntity<Object> handleStudentNotFoundExection(ActorNotFoundException nda) {
	        LocalDate dateTime = LocalDate.now();
	        ErrorDetails details = new ErrorDetails(dateTime, nda.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(details);
	    }
	    
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException excp){
	        List<String> err=excp.getBindingResult().getFieldErrors().stream().map(error->error.getDefaultMessage())
	                .collect(Collectors.toList());
	        Map<String, List<String>> errorRes=new HashMap<>();
	        errorRes.put("error", err);
	        
	        return new ResponseEntity<>(errorRes,HttpStatus.BAD_GATEWAY);
	    }
	 
	}
