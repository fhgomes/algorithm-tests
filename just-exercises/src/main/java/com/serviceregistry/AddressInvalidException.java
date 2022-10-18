package com.serviceregistry;

public class AddressInvalidException extends RuntimeException {
    public AddressInvalidException() {
        super("address.invalid");
    }
}
