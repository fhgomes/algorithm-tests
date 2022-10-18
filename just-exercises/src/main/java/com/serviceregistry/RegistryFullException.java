package com.serviceregistry;

import static java.lang.String.format;

public class RegistryFullException extends RuntimeException {
    public RegistryFullException(String instanceName) {
        super(format("Registry is full for %s", instanceName));
    }
}
