package com.palindrome;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CheckIsPalindromeTest {

    CheckIsPalindrome target = new CheckIsPalindrome();

    @Test
    void testAna() {
        assertTrue(target.checkPalindrome("ana"));
    }

    @Test
    void testRacecar() {
        assertTrue(target.checkPalindrome("racecar"));
    }

    @Test
    void testFernando() {
        assertFalse(target.checkPalindrome("Fernando"));
    }

}