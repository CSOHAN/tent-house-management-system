package com.thms.tenthouse.common.exceptions;

public class CustomerAlreadyExistsException
    extends RuntimeException {

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
