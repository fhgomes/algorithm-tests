package com.serviceregistry;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SimpleServiceRegistryTest {

    @InjectMocks
    SimpleServiceRegistry target;

    @Spy
    Map<String, Set<URI>> mockStorage = new HashMap();

    @BeforeEach
    void setUp() {
    }

    /*
    It should be possible to register an instance, identified by an address
    Each address should be unique, it should not be possible to register the same address more than once
    Service Registry should accept up to 10 addresses
    */

    @Test
    void shouldRegistry10UniqueAddressToServiceA() {
        target.register("a", toURI("10.0.0.1/a"));
        target.register("a", toURI("10.0.0.2/a"));
        target.register("a", toURI("10.0.0.3/a"));
        target.register("a", toURI("10.0.0.4/a"));
        target.register("a", toURI("10.0.0.5/a"));
        target.register("a", toURI("10.0.0.6/a"));
        target.register("a", toURI("10.0.0.7/a"));
        target.register("a", toURI("10.0.0.8/a"));
        target.register("a", toURI("10.0.0.9/a"));
        assertDoesNotThrow(() -> target.register("a", toURI("10.0.0.10/a")));

    }

    @Test
    void shouldRegistry10UniqueAddressToServiceAAndOneOnB() {
        target.register("a", toURI("10.0.0.1/a"));
        target.register("a", toURI("10.0.0.2/a"));
        target.register("a", toURI("10.0.0.3/a"));
        target.register("a", toURI("10.0.0.4/a"));
        target.register("a", toURI("10.0.0.5/a"));
        target.register("a", toURI("10.0.0.6/a"));
        target.register("a", toURI("10.0.0.7/a"));
        target.register("a", toURI("10.0.0.8/a"));
        target.register("a", toURI("10.0.0.9/a"));
        assertDoesNotThrow(() -> target.register("a", toURI("10.0.0.10/a")));
        assertDoesNotThrow(() -> target.register("b", toURI("10.0.0.10/a")));

    }

    @Test
    void shouldNotAllowMoreThan10RegistryToServiceA() {
        target.register("a", toURI("10.0.0.1/a"));
        target.register("a", toURI("10.0.0.2/a"));
        target.register("a", toURI("10.0.0.3/a"));
        target.register("a", toURI("10.0.0.4/a"));
        target.register("a", toURI("10.0.0.5/a"));
        target.register("a", toURI("10.0.0.6/a"));
        target.register("a", toURI("10.0.0.7/a"));
        target.register("a", toURI("10.0.0.8/a"));
        target.register("a", toURI("10.0.0.9/a"));
        target.register("a", toURI("10.0.0.10/a"));

        assertThrows(RegistryFullException.class, () -> target.register("a", toURI("10.0.0.10/a")));
    }

    @Test
    void shouldRegistryUniqueAddressToServiceA() {
        target.register("a", toURI("10.0.0.1/a"));
        assertThrows(AddressAlreadyRegisteredException.class, () -> target.register("a", toURI("10.0.0.1/a")));

    }

    @RepeatedTest(value = 10)
    void shouldRetrieveRandomAddressOfInstance(RepetitionInfo testInfo) {
        int randomSize = new Random().ints(1, 11).findFirst().getAsInt();

        for (int i = 1; i < randomSize; i++) {
            target.register("a", URI.create("10.0.0."+i+"/a"));
        }

        URI returnedAddress = target.retrieveAddressOfInstance("a");
        Set<URI> mockStorageValuesForA = mockStorage.get("a");

        assertTrue(mockStorageValuesForA.contains(returnedAddress));
    }

    private static URI toURI(String str) {
        return URI.create(str);
    }
}