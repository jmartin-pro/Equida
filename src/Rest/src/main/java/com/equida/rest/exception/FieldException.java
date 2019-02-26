package com.equida.rest.exception;

public class FieldException extends WebException {

    private String field;

    public FieldException(Throwable e) {
        super(e);
    }

    public FieldException(String message) {
        super(message);
    }

    public FieldException(String field, String message) {
        super(message);

        this.field = field;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
