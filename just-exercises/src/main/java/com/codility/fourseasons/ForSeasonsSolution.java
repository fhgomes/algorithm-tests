package com.codility.fourseasons;

import java.util.Arrays;

public class ForSeasonsSolution {
    /*
        //T is always divisible by 4
        //always have four different season amplitures
        //given temperatures, calc the diff of max and min temperature to get amplitude
        //winter, spring, summer, autumn
     */
    public String solution(int[] T) {
        int seasonDaysLength = T.length /4;
        int startSeason = 0;
        int endSeason = startSeason + seasonDaysLength;

        int amplitudeWinter = calcAmplitudeOf(Arrays.copyOfRange(T, startSeason, endSeason));

        startSeason = endSeason;
        endSeason = endSeason + seasonDaysLength;
        int amplitudeSpring = calcAmplitudeOf(Arrays.copyOfRange(T, startSeason, endSeason));

        startSeason = endSeason;
        endSeason = endSeason + seasonDaysLength;
        int amplitudeSummer = calcAmplitudeOf(Arrays.copyOfRange(T, startSeason, endSeason));

        startSeason = endSeason;
        endSeason = endSeason + seasonDaysLength;
        int amplitudeAutumn = calcAmplitudeOf(Arrays.copyOfRange(T, startSeason, endSeason));

        if (isBiggerThan(amplitudeWinter, amplitudeSpring, amplitudeSummer, amplitudeAutumn)) {
            return "WINTER";
        }

        if (isBiggerThan(amplitudeSpring, amplitudeWinter, amplitudeSummer, amplitudeAutumn)) {
            return "SPRING";
        }

        if (isBiggerThan(amplitudeSummer, amplitudeSpring, amplitudeWinter, amplitudeAutumn)) {
            return "SUMMER";
        }

        return "AUTUMN";
    }

    private boolean isBiggerThan(int amplitudeSeason, int... otherSeason) {
        boolean bigger = true;
        for (int amplitudeOther : otherSeason) {
            if (amplitudeOther > amplitudeSeason) {
                return false;
            }
        }
        return bigger;
    }

    private int calcAmplitudeOf(int[] seasonTemperatures) {
        int min = seasonTemperatures[0];
        int max = seasonTemperatures[0];

        for (int seasonTemperature : seasonTemperatures) {
            if (seasonTemperature < min) {
                min = seasonTemperature;
            } else
            if (seasonTemperature > max) {
                max = seasonTemperature;
            }
        }

        if (min <= max){
            return max - min;
        }
        return min - max;
    }

}
