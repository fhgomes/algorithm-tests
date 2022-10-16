package com.secondlargenum;

public class FindSecondLargestV2 {
    public Integer find(Integer... numbers) {
        if (numbers.length < 2) {
            return null;
        }

        int maxInt = numbers[0];
        int maxSecInt = 0 ;


        for (Integer number : numbers) {
            if (number > maxInt) {
                maxInt = number;
            }

            if (number > maxSecInt && number < maxInt) {
                maxSecInt = number;
            }

            System.out.println("maxInt: "+maxInt);
            System.out.println("maxSecInt: "+maxSecInt);
            System.out.println("number: "+number);
            System.out.println();
        }

        if (maxSecInt == 0) {
            maxSecInt = maxInt;
        }

        // ->  TIME O(n)
        // ->  SPACE O(1)

        return maxSecInt;
    }

}
