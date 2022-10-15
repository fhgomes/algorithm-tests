package com.serviceregistry;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class SimpleServiceRegistryTest {

    @InjectMocks
    SimpleServiceRegistry target;

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
        target.register("a", "10.0.0.1/a");
        target.register("a", "10.0.0.2/a");
        target.register("a", "10.0.0.3/a");
        target.register("a", "10.0.0.4/a");
        target.register("a", "10.0.0.5/a");
        target.register("a", "10.0.0.6/a");
        target.register("a", "10.0.0.7/a");
        target.register("a", "10.0.0.8/a");
        target.register("a", "10.0.0.9/a");
        assertDoesNotThrow(() -> target.register("a", "10.0.0.10/a"));

    }

    @Test
    void shouldRegistry10UniqueAddressToServiceAAndOneOnB() {
        target.register("a", "10.0.0.1/a");
        target.register("a", "10.0.0.2/a");
        target.register("a", "10.0.0.3/a");
        target.register("a", "10.0.0.4/a");
        target.register("a", "10.0.0.5/a");
        target.register("a", "10.0.0.6/a");
        target.register("a", "10.0.0.7/a");
        target.register("a", "10.0.0.8/a");
        target.register("a", "10.0.0.9/a");
        assertDoesNotThrow(() -> target.register("a", "10.0.0.10/a"));
        assertDoesNotThrow(() -> target.register("b", "10.0.0.10/a"));

    }

    @Test
    void shouldNotAllowMoreThan10RegistryToServiceA() {
        target.register("a", "10.0.0.1/a");
        target.register("a", "10.0.0.2/a");
        target.register("a", "10.0.0.3/a");
        target.register("a", "10.0.0.4/a");
        target.register("a", "10.0.0.5/a");
        target.register("a", "10.0.0.6/a");
        target.register("a", "10.0.0.7/a");
        target.register("a", "10.0.0.8/a");
        target.register("a", "10.0.0.9/a");
        target.register("a", "10.0.0.10/a");

        assertThrows(RuntimeException.class, () -> target.register("a", "10.0.0.10/a"));
    }

    @Test
    void shouldRegistryUniqueAddressToServiceA() {
        target.register("a", "10.0.0.1/a");
        assertThrows(RuntimeException.class, () -> target.register("a", "10.0.0.1/a"));

    }

    @Test
    @RepeatedTest(9)
    void shouldRetrieveRandomAddressOfInstance() {
        List<String> addresses = new ArrayList<>();

        for (int i = 0; i < new Random().nextInt(10); i++) {
            target.register("a", "10.0.0."+i+"/a");
        }

        assertDoesNotThrow(() -> {
            System.out.println(target.retrieveAddressOfInstance("a"));
        });
    }
}