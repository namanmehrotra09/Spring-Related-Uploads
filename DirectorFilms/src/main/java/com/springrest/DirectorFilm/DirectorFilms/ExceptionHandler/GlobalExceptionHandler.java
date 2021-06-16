package com.springrest.DirectorFilm.DirectorFilms.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springrest.DirectorFilm.DirectorFilms.Exceptions.ErrorDetails;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.InvalidDataException;
import com.springrest.DirectorFilm.DirectorFilms.Exceptions.NameInvalidException;


@ControllerAdvice
public class GlobalExceptionHandler 
{
		//Handle specific Exceptions
		@ExceptionHandler(InvalidDataException.class)
		public ResponseEntity<?> invalidDataException(InvalidDataException ex, WebRequest request)
		{
			ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
			return new ResponseEntity<>(errDetails,HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		//Handle specific Exceptions
		@ExceptionHandler(NameInvalidException.class)
		public ResponseEntity<?> nameInvalidException(NameInvalidException ex, WebRequest request)
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
