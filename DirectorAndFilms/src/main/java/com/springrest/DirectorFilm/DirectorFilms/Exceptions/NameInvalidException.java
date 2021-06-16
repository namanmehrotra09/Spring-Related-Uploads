package com.springrest.DirectorFilm.DirectorFilms.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NameInvalidException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NameInvalidException(String message)
	{
		super(message);
	}
}
