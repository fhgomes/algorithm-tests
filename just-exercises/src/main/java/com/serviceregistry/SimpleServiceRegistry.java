package com.serviceregistry;

import static java.util.Objects.isNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/*
    It should be possible to register an instance, identified by an address
    Each address should be unique, it should not be possible to register the same address more than once
    Service Registry should accept up to 10 addresses
 */
/*
    Develop an algorithm that,
        when invoking the Service Registry's get() method multiple times,
        should return one backend-instance choosing between the registered ones randomly.
 */
public class SimpleServiceRegistry {
    // "service.com/myservice1" -> [10.0.0.1/myservice1, 10.0.0.2/myservice1]

    private Map<String, Set<String>> nameAddressRegistry = new HashMap<>();

    public void register(String serviceInstanceName, String address) {
        if (isNull(nameAddressRegistry.get(serviceInstanceName))) {
            Set<String> addresses = new HashSet<>();
            addresses.add(address);
            nameAddressRegistry.put(serviceInstanceName, addresses);
        } else {
            Set<String> instanceValues = nameAddressRegistry.get(serviceInstanceName);
            if (instanceValues.size() == 10) {
                throw new RuntimeException("its full");
            }
            if (!instanceValues.contains(address)) {
                instanceValues.add(address);
            } else {
                throw new RuntimeException("its already registered");
            }
        }
    }

    public String retrieveAddressOfInstance(String instance) {
        Set<String> maybeRegisteredAddresses = nameAddressRegistry.get(instance);

        if (isNull(maybeRegisteredAddresses)) {
            throw new InstanceNotFoundException(instance);
        }

        int randomAddress = new Random().nextInt(maybeRegisteredAddresses.size());
        List<String> addressList = maybeRegisteredAddresses.stream().collect(Collectors.toList());

        return addressList.get(randomAddress);
    }
}
