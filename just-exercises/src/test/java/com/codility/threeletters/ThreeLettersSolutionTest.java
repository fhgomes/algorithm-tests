package com.codility.threeletters;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreeLettersSolutionTest {

    ThreeLettersSolution target = new ThreeLettersSolution();

    /*
    Given A = 5 and B = 3, your function may return "aabaabab".
    Note that "abaabbaa" would also be a correct answer.
     */
    @Test
    void firstCase() {
        String result = target.distributeLetters(5, 3);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(5, countA);
        assertEquals(3, countB);
        assertFalse(result.contains("aaa"));
        assertFalse(result.contains("bbb"));
    }

    /*
    Given A = 3 and B = 3,
        should return "ababab", "aababb", "abaabb"
        or any of several other strings.
     */
    @Test
    void secondCase() {
        String result = target.distributeLetters(3, 3);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(3, countA);
        assertEquals(3, countB);
        assertFalse(result.contains("aaa"));
        assertFalse(result.contains("bbb"));
    }

    /*
    3. Given A = 1 and B = 4,
        should return "bbabb", which is the only correct answer in this case.
     */

    @Test
    void oneACase() {
        String result = target.distributeLetters(1, 4);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(1, countA);
        assertEquals(4, countB);
        assertFalse(result.contains("aaa"));
        assertFalse(result.contains("bbb"));
    }

    @Test
    void oneBCase() {
        String result = target.distributeLetters(4, 1);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(4, countA);
        assertEquals(1, countB);
        assertFalse(result.contains("aaa"));
        assertFalse(result.contains("bbb"));
    }

        /*
    3. Given A = 1 and B = 4,
        should return "bbabb", which is the only correct answer in this case.
     */

    @Test
    void moreAThanBCase() {
        String result = target.distributeLetters(8, 4);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(8, countA);
        assertEquals(4, countB);
        assertFalse(result.contains("aaa"), "sequence aaa detected");
        assertFalse(result.contains("bbb"), "sequence bbb detected");
    }

    @Test
    void doubleACase() {
        String result = target.distributeLetters(60, 30);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(60, countA);
        assertEquals(30, countB);
        assertFalse(result.contains("aaa"), "sequence aaa detected");
        assertFalse(result.contains("bbb"), "sequence bbb detected");
    }

    @Test
    void doubleBCase() {
        String result = target.distributeLetters(30, 60);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(30, countA);
        assertEquals(60, countB);
        assertFalse(result.contains("aaa"), "sequence aaa detected");
        assertFalse(result.contains("bbb"), "sequence bbb detected");
    }

    @Test
    void maxCase() {
        String result = target.distributeLetters(100, 100);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(100, countA);
        assertEquals(100, countB);
        assertFalse(result.contains("aaa"), "sequence aaa detected");
        assertFalse(result.contains("bbb"), "sequence bbb detected");
    }

    @Test
    void zeroCase() {
        String result = target.distributeLetters(0, 0);
        System.out.println(result);

        long countA = result.chars().filter(ch -> ch == 'a').count();
        long countB = result.chars().filter(ch -> ch == 'b').count();
        assertEquals(0, countA);
        assertEquals(0, countB);
        assertFalse(result.contains("aaa"), "sequence aaa detected");
        assertFalse(result.contains("bbb"), "sequence bbb detected");
    }
}