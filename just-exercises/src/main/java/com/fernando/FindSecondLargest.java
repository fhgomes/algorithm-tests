package com.fernando;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindSecondLargest {
    public Integer findSecondLargest(Integer... numbers) {
        if (numbers.length < 2) {
            return null;
        }

        Set<Integer> uniqueInts = Arrays.stream(numbers).collect(Collectors.toSet());

        if (uniqueInts.size() == 1) {
            return uniqueInts.stream().findFirst().get();
        }

        return uniqueInts.stream().sorted().collect(Collectors.toList()).get(uniqueInts.size()-2);
    }

}
