package com.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class NoSuchElementFoundException extends  RuntimeException {

    public NoSuchElementFoundException(String errorMessage) {
        super(errorMessage);
    }

    public NoSuchElementFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
