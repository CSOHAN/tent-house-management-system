package com.thms.tenthouse.common.exceptions;

public class CustomerNotFoundException
    extends RuntimeException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
