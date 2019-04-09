package com.equida.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception {

	public NotFoundException() {
		super("La page demandée n'existe pas.");
	}

	public NotFoundException(String msg) {
		super(msg);
	}

}
