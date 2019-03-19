package com.equida.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class NotFoudException extends RuntimeException {

	public NotFoudException(String msg) {
		super(msg);
	}

}
