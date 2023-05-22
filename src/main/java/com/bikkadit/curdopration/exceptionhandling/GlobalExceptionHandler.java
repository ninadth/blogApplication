package com.bikkadit.curdopration.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(UserNotFoundException ex){
		
		String message = ex.getMessage();
		
        ApiResponse api=new ApiResponse(message, ErrorCode.USERN);
		
		return new ResponseEntity<ApiResponse>(api,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArragument(MethodArgumentNotValidException ex)
	{
		Map<String , String> m=new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String field=((FieldError)error).getField();
			
			String defaultMessage = error.getDefaultMessage();
			
			m.put(field, defaultMessage);
		});
		return new ResponseEntity<Map<String,String>> (m,HttpStatus.BAD_REQUEST);
		
}}
