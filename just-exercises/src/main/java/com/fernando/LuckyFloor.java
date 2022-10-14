package com.fernando;

import java.util.ArrayList;
import java.util.List;

class LuckyFloor {

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
        String stringNumber = Integer.toString(number);
        return !stringNumber.contains("4") && !stringNumber.contains("13");
    }
}
