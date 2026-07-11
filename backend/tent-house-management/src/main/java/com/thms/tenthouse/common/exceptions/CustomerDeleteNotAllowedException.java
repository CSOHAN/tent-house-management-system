package com.thms.tenthouse.common.exceptions;

public class CustomerDeleteNotAllowedException
    extends RuntimeException {

    public CustomerDeleteNotAllowedException(
        String message) {
        super(message);
    }
}
