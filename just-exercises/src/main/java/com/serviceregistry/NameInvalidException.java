package com.serviceregistry;

public class NameInvalidException extends RuntimeException {
    public NameInvalidException() {
        super("name.invalid");
    }
}
