package com.elRols.app.errorHandler.exception;

public class GenericException extends RuntimeException {

    public GenericException(String message) {
        super(message);
    }

    public GenericException(String message, Throwable e) {
        super(message, e);
    }
}
