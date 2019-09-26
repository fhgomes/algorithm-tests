package com.fernando;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LuckyFloorTest {

    // Complete the getLuckyFloorNumber function below.
    static int getLuckyFloorNumber(int n) {
        int luckyNumber = n;

        if (luckyNumber < 4) {
            return luckyNumber;
        }

        if (luckyNumber == 4) {
            return 5;
        }

        return getLuckyOrNextNotUsed(luckyNumber);
    }

    private static int getLuckyOrNextNotUsed(int luckyNumber) {
        List<Integer> alreadyUsed = new ArrayList<>();
        int countRemoved = 0;

        int usedNumber = 3;
        while (usedNumber <= luckyNumber) {
            int numberWithLucky = getLuckyNumber(usedNumber);
            if(numberWithLucky != usedNumber) {
                countRemoved++;
            }
            alreadyUsed.add(getLuckyNumber(usedNumber));
            usedNumber++;
        }

        if (alreadyUsed.contains(luckyNumber)) {
            return getLuckyNumber(luckyNumber+countRemoved);
        }
        return luckyNumber;
    }

    private static int getLuckyNumber(int luckyNumber) {
        if(isNumberWithLuck(luckyNumber)) {
            return luckyNumber;
        }
        return getLuckyNumber(luckyNumber+1);
    }

    static boolean isNumberWithLuck(int number) {
        String stringNumber = Integer.valueOf(number).toString();
        if(stringNumber.contains("4") || stringNumber.contains("13")) {
            return false;
        }
        return true;
    }

    @Test
    public void teste1() {
        assertEquals(1, getLuckyFloorNumber(1));
    }

    @Test
    public void teste4() {
        assertEquals(5, getLuckyFloorNumber(4));
    }

    @Test
    public void teste5() {
        assertEquals(6, getLuckyFloorNumber(5));
    }

    @Test
    public void teste6() {
        assertEquals(7, getLuckyFloorNumber(6));
    }

    @Test
    public void teste11() {
        assertEquals(12, getLuckyFloorNumber(11));
    }

    @Test
    public void teste12() {
        assertEquals(15, getLuckyFloorNumber(12));
    }
}
