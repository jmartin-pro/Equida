package com.equida.webapp.exception;

public class WebException extends Exception {

    public WebException(Throwable e) {
        super(e);
    }

    public WebException(String message) {
        super(message);
    }
}
