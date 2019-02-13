package com.equida.exception;

public class FormException extends WebException {

    private String field;

    public FormException(Throwable e) {
        super(e);
    }

    public FormException(String message) {
        super(message);
    }

    public FormException(String field, String message) {
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
