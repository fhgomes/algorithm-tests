package com.serviceregistry;

import static java.util.Objects.isNull;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
    It should be possible to register an instance, identified by an address
    Each address should be unique, it should not be possible to register the same address more than once
    Service Registry should accept up to 10 addresses
 */
// "service.com/myservice1" -> [10.0.0.1/myservice1, 10.0.0.2/myservice1]
/*
    Develop an algorithm that,
        when invoking the Service Registry's get() method multiple times,
        should return one backend-instance choosing between the registered ones randomly.


 */
public class SimpleServiceRegistry {
    public static final int MAX_ADDRESS_BY_INSTANCE = 10;

    private final Map<String, List<URI>> nameAddressRegistry;
    private final Random retrieveAccessor;

    public SimpleServiceRegistry(Map<String, List<URI>> storage) {
        validateStorage(storage);
        this.nameAddressRegistry = storage;
        this.retrieveAccessor = new Random();
    }

    public void register(String serviceInstanceName, URI address) {
        validateServiceName(serviceInstanceName);
        validateAddress(address);

        doRegister(serviceInstanceName, address);
    }

    private void doRegister(String serviceInstanceName, URI address) {
        if (isNull(nameAddressRegistry.get(serviceInstanceName))) {
            List<URI> addresses = new ArrayList<>();
            addresses.add(address);
            nameAddressRegistry.put(serviceInstanceName, addresses);
        } else {
            List<URI> instanceValues = nameAddressRegistry.get(serviceInstanceName);
            if (instanceValues.size() == MAX_ADDRESS_BY_INSTANCE) {
                throw new RegistryFullException(serviceInstanceName);
            }
            if (instanceValues.contains(address)) {
                throw new AddressAlreadyRegisteredException(serviceInstanceName, address.toString());
            }
            instanceValues.add(address);

        }
    }

    public URI retrieveAddressOfInstance(String serviceInstanceName) {
        validateServiceName(serviceInstanceName);
        List<URI> maybeRegisteredAddresses = nameAddressRegistry.get(serviceInstanceName);

        if (isNull(maybeRegisteredAddresses)) {
            throw new InstanceNotFoundException(serviceInstanceName);
        }

        int randomAddress = retrieveAccessor.nextInt(maybeRegisteredAddresses.size());

        return maybeRegisteredAddresses.get(randomAddress);
    }

    private static void validateAddress(URI address) {
        if (isNull(address)) {
            throw new AddressInvalidException();
        }
    }

    private static void validateStorage(Map<String, List<URI>> storage) {
        if (isNull(storage)) {
            throw new StoreInvalidException();
        }
    }

    private static void validateServiceName(String serviceInstanceName) {
        if (isNull(serviceInstanceName) || serviceInstanceName.isEmpty()) {
            throw new NameInvalidException();
        }
    }
}
