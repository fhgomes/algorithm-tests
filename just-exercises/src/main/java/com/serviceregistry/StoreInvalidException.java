package com.serviceregistry;

public class StoreInvalidException extends RuntimeException {
    public StoreInvalidException() {
        super("store.invalid");
    }
}
