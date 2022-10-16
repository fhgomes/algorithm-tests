package com.packnumbers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PackNumbersTest {

    PackNumbers target;

    @BeforeEach
    void setUp() {
        target = new PackNumbers();
    }


    @Test
    public void testePackWithout() {
        List<String> packed = target.packNumbers(Arrays.asList(5, 7, 4, 3));
        assertEquals("5", packed.get(0));
        assertEquals("7", packed.get(1));
        assertEquals("4", packed.get(2));
        assertEquals("3", packed.get(3));
    }

    @Test
    public void testePackOne() {
        List<String> packed = target.packNumbers(Arrays.asList(5, 5, 7, 4, 3));
        assertEquals("5:2", packed.get(0));
        assertEquals("7", packed.get(1));
        assertEquals("4", packed.get(2));
        assertEquals("3", packed.get(3));
    }

    @Test
    public void testePackTwo() {
        List<String> packed = target.packNumbers(Arrays.asList(5, 5, 5, 7, 7, 4, 3));
        assertEquals("5:3", packed.get(0));
        assertEquals("7:2", packed.get(1));
        assertEquals("4", packed.get(2));
        assertEquals("3", packed.get(3));
    }
}