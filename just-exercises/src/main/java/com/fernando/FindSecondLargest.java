package com.fernando;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindSecondLargest {
    public Integer find(Integer... numbers) {
        if (numbers.length < 2) {
            return null;
        }

        // O(n)
        Set<Integer> uniqueInts = Arrays.stream(numbers).collect(Collectors.toSet());

        if (uniqueInts.size() == 1) {
            return uniqueInts.stream().findFirst().get();
        }

        // ->  O(n log n)
        Stream<Integer> sorted = uniqueInts.stream().sorted();

        // ->  TIME O(n log n)
        // ->  SPACE O(n)

        return sorted.collect(Collectors.toList()).get(uniqueInts.size()-2);
    }

}
