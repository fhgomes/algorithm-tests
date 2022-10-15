package com.serviceregistry;

public class InstanceNotFoundException extends RuntimeException {
    public InstanceNotFoundException(String instanceName) {
        super(instanceName);
    }
}
