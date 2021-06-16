package com.mt.IMS.Exception.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.mt.IMS.Exception.ErrorDetails;
import com.mt.IMS.Exception.InvalidIdException;
import com.mt.IMS.Exception.NotEnoughQuantityException;

@ControllerAdvice
public class GlobalExceptionHandler 
{
		//Handle specific Exceptions
		@ExceptionHandler(NotEnoughQuantityException.class)
		public ResponseEntity<?> invalidDataException(NotEnoughQuantityException ex, WebRequest request)
		{
			ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errDetails,HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		//Handle specific Exceptions
		@ExceptionHandler(InvalidIdException.class)
		public ResponseEntity<?> invalidIdException(InvalidIdException ex, WebRequest request)
		{
			ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errDetails,HttpStatus.NOT_FOUND);
		}
		
		//Handle Global Exception
		@ExceptionHandler(Exception.class)
	    public ResponseEntity<?> globalExceptionHandler(Exception ex, WebRequest request) {
	        ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
	        return new ResponseEntity<>(errDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
}
