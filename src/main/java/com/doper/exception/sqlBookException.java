package com.doper.exception;

public class sqlBookException extends Exception{
    public sqlBookException() {
    }

    public sqlBookException(String message) {
        super(message);
    }

    public sqlBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public sqlBookException(Throwable cause) {
        super(cause);
    }
}
