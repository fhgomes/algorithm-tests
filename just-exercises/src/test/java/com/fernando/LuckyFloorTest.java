package com.fernando;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LuckyFloorTest {

    LuckyFloor target;

    @BeforeEach
    void setUp() {
        target = new LuckyFloor();
    }

    @Test
    public void teste1() {
        assertEquals(1, target.getLuckyFloorNumber(1));
    }

    @Test
    public void teste4() {
        assertEquals(5, target.getLuckyFloorNumber(4));
    }

    @Test
    public void teste5() {
        assertEquals(6, target.getLuckyFloorNumber(5));
    }

    @Test
    public void teste6() {
        assertEquals(7, target.getLuckyFloorNumber(6));
    }

    @Test
    public void teste11() {
        assertEquals(12, target.getLuckyFloorNumber(11));
    }

    @Test
    public void teste12() {
        assertEquals(15, target.getLuckyFloorNumber(12));
    }
}