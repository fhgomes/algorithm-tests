package com.fernando;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("squid:ForLoopCounterChangedCheck")
 class PackNumbers {
    // Complete the packNumbers function below.
    static List<String> packNumbers(List<Integer> originArray) {
        List<String> packNumbers = new ArrayList<>();
        if (isNull(originArray) || originArray.isEmpty()) {
            return packNumbers;
        }

        for (int currentPos = 0; currentPos < originArray.size(); currentPos++) {
            String number = originArray.get(currentPos).toString();
            int nextPos = currentPos;
            String numberNext = originArray.get(nextPos).toString();
            int count = 0;
            while (number.equals(numberNext)) {
                if(currentPos != nextPos) {
                    currentPos = nextPos;
                }
                nextPos++;
                count++;

                if(nextPos >= originArray.size()) {
                    break;
                }
                numberNext = originArray.get(nextPos).toString();
            }

            if(count <=1) {
                packNumbers.add(number);
            } else {
                packNumbers.add(number+":"+count);
            }
        }
        return packNumbers;
    }

}
