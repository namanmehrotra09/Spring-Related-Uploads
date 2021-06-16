package com.springrest.EmployeeManagementSystem.EMS.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springrest.EmployeeManagementSystem.EMS.Exception.ErrorDetails;
import com.springrest.EmployeeManagementSystem.EMS.Exception.ResourceNotFoundException;

@ControllerAdvice
public class EmployeeGlobalHandlerException 
{
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request)
	{
		ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExceptionHandler(Exception ex, WebRequest request) {
        ErrorDetails errDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
