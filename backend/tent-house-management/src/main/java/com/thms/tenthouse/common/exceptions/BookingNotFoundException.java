package com.thms.tenthouse.common.exceptions;

public class BookingNotFoundException
    extends RuntimeException {

    public BookingNotFoundException(String message) {
        super(message);
    }
}
