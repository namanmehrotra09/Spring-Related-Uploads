package com.mt.springeurekaclientstudentservice.exception.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.mt.springeurekaclientstudentservice.exception.ErrorDetails;
import com.mt.springeurekaclientstudentservice.exception.StudentNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler 
{
		//Handle specific Exceptions
		@ExceptionHandler(StudentNotFoundException.class)
		public ResponseEntity<?> studentNotFoundException(StudentNotFoundException ex, WebRequest request)
		{
			ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errDetails,HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		//Handle Global Exception
		@ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
	        ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
