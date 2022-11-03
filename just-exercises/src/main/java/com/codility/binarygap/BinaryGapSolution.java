package com.codility.binarygap; // you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class BinaryGapSolution {

    public int findMaxZeroGap(int N) {
        // write your code in Java SE 11
         String binaryValue = Integer.toBinaryString(N);
         int maxGap = 0;
         int tempGap = 0;
         boolean leftHasOne = false;
         for (int i = 0; i < binaryValue.length(); i++) {
             char zeroOrOne = binaryValue.charAt(i);
             if (zeroOrOne == '1') {
                 if (leftHasOne && maxGap < tempGap) {
                     maxGap = tempGap;
                 } else {
                    leftHasOne = true;
                 }
                 tempGap = 0;
                 continue;
             }
             if (leftHasOne && zeroOrOne == '0') {
                 tempGap++;
             }
         }

         return maxGap;
    }
}