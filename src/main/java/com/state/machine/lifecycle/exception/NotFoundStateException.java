package com.state.machine.lifecycle.exception;

public class NotFoundStateException extends RuntimeException {

    public NotFoundStateException(String message) {
        super(message);
    }
}
