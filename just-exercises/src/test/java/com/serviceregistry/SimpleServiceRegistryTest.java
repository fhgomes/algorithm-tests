package com.serviceregistry;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
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

    public static final String SERVICE_NAME_A = "a";
    public static final String SERVICE_NAME_B = "b";
    @InjectMocks
    SimpleServiceRegistry target;

    @Spy
    Map<String, List<URI>> mockStorage = new HashMap();

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
        for (int i = 1; i <= 9; i++) {
            target.register(SERVICE_NAME_A, URI.create("10.0.0."+i+"/a"));
        }

        assertDoesNotThrow(() -> target.register(SERVICE_NAME_A, toURI("10.0.0.10/a")));

    }

    @Test
    void shouldRegistry10UniqueAddressToServiceAAndOneOnB() {
        for (int i = 1; i <= 9; i++) {
            target.register(SERVICE_NAME_A, URI.create("10.0.0."+i+"/a"));
        }

        assertDoesNotThrow(() -> target.register(SERVICE_NAME_A, toURI("10.0.0.10/a")));
        assertDoesNotThrow(() -> target.register(SERVICE_NAME_B, toURI("10.0.0.10/a")));
    }

    @Test
    void shouldNotAllowMoreThan10RegistryToServiceA() {
        for (int i = 1; i <= 10; i++) {
            target.register(SERVICE_NAME_A, URI.create("10.0.0."+i+"/a"));
        }

        assertThrows(
                RegistryFullException.class,
                () -> target.register(SERVICE_NAME_A, toURI("10.0.0.11/a"))
        );
    }

    @Test
    void shouldRegistryUniqueAddressToServiceA() {
        target.register(SERVICE_NAME_A, toURI("10.0.0.1/a"));

        assertThrows(
                AddressAlreadyRegisteredException.class,
                () -> target.register(SERVICE_NAME_A, toURI("10.0.0.1/a"))
        );
    }

    @RepeatedTest(value = 10)
    void shouldRetrieveRandomAddressOfInstance() {
        int randomSize = new Random().ints(1, 11).findFirst().getAsInt();

        for (int i = 1; i <= randomSize; i++) {
            target.register(SERVICE_NAME_A, URI.create("10.0.0."+i+"/a"));
        }

        URI returnedAddress = target.retrieveAddressOfInstance(SERVICE_NAME_A);
        List<URI> mockStorageValuesForA = mockStorage.get(SERVICE_NAME_A);

        assertTrue(mockStorageValuesForA.contains(returnedAddress));
    }

    private static URI toURI(String str) {
        return URI.create(str);
    }
}