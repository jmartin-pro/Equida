package com.equida.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class WebException extends Exception {

    public WebException(Throwable e) {
        super(e);
    }

    public WebException(String message) {
        super(message);
    }
}
