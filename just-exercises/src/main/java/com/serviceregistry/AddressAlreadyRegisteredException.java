package com.serviceregistry;

import static java.lang.String.format;

public class AddressAlreadyRegisteredException extends RuntimeException {
    public AddressAlreadyRegisteredException(String instanceName, String address) {
        super(format("Registry [%s] already registered for [%s]", address, instanceName));
    }
}
