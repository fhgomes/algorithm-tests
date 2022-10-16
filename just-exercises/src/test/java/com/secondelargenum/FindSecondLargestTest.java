package com.secondelargenum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.secondlargenum.FindSecondLargest;
import org.junit.jupiter.api.Test;

/*
   Write a function that returns the second largest number of an array
   e.g. [101, 99, 34, 2, 17]
   Returns 99

   Code test cases:
       [1000, 313, 1000, 313, 1000, 313, 24] => 313
       [2500, 2500, 777, 777, 50, 777] => 777
       [17, 17] => 17
       [17] => No second largest
       [] => empty array

    */
class FindSecondLargestTest {

    // e.g. [101, 99, 34, 2, 17] -> 99
    @Test
    void shouldFindSecondValue99() {
        FindSecondLargest target = new FindSecondLargest();

        Integer maybeSecond = target.find(101, 99, 34, 2, 17);

        assertEquals(99, maybeSecond);
    }


    //   [1000, 313, 1000, 313, 1000, 313, 24] => 313
    @Test
    void shouldFindSecondValue313() {
        FindSecondLargest target = new FindSecondLargest();

        Integer maybeSecond = target.find(1000, 313, 1000, 313, 1000, 313, 24);

        assertEquals(313, maybeSecond);
    }

    //   [2500, 2500, 777, 777, 50, 777] => 777
    @Test
    void shouldFindSecondValue777() {
        FindSecondLargest target = new FindSecondLargest();

        Integer maybeSecond = target.find(2500, 2500, 777, 777, 50, 777);

        assertEquals(777, maybeSecond);
    }

    //   [17, 17] => 17
    @Test
    void shouldFindSecondValueWith2Equal() {
        FindSecondLargest target = new FindSecondLargest();

        Integer maybeSecond = target.find(17, 17);

        assertEquals(17, maybeSecond);
    }

    //   [17] => No second largest
    @Test
    void shouldFindSecondValueWithOne() {
        FindSecondLargest target = new FindSecondLargest();

        Integer maybeSecond = target.find(17);

        assertNull(maybeSecond);
    }

    //   [] => empty array
    @Test
    void shouldFindSecondValueWithEmpty() {
        FindSecondLargest target = new FindSecondLargest();

        Integer maybeSecond = target.find();

        assertNull(maybeSecond);
    }
}