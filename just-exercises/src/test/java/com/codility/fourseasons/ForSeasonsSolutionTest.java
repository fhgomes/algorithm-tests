package com.codility.fourseasons;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ForSeasonsSolutionTest {

    @Test
    void testCaseTwoTemperaturesEach() {
        ForSeasonsSolution target = new ForSeasonsSolution();
        String seasonResult = target.solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3});
        assertEquals("SUMMER", seasonResult);
    }

    @Test
    void testCase3TemperaturesEach() {

        String[] split = "value".split(";");
        String first = split[0];
        System.out.println(first);
        ForSeasonsSolution target = new ForSeasonsSolution();
        String seasonResult = target.solution(new int[]{2, -3, 3, 1, 10, 8, 2, 5, 13, -5, 3, -13});
        assertEquals("AUTUMN", seasonResult);
    }

    @Test
    void testWithTemperatureWith2EqualValue() {
        ForSeasonsSolution target = new ForSeasonsSolution();
        String seasonResult = target.solution(new int[]{2, 2, 56, 1, 10, 8, 2, 5, 13, -5, 3, -13});
        assertEquals("WINTER", seasonResult);
    }

    @Test
    void testWithTemperatureWith3EqualValue() {
        ForSeasonsSolution target = new ForSeasonsSolution();
        String seasonResult = target.solution(new int[]{2, 2, 2, -50, -50, 8, 2, 5, 13, -5, 3, -13});
        assertEquals("SPRING", seasonResult);
    }

    @Test
    void testWithZeroTemperatures() {
        ForSeasonsSolution target = new ForSeasonsSolution();
        String seasonResult = target.solution(new int[]{0, 0, 0, -50, -50, 8, 2, 5, 13, -5, 3, -13});
        assertEquals("SPRING", seasonResult);
    }
}