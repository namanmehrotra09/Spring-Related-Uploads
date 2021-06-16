package com.mt.IMS.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
public class NotEnoughQuantityException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NotEnoughQuantityException(String message)
	{
		super(message);
	}

}
