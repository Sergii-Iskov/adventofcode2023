package com.shpp.p2p.cs.siskov.adventofcode;

/**
 * This task "Day 6: Wait For It" is from https://adventofcode.com/2023/day/6
 * We need to calculate How many ways can we beat the record in this one much longer race.
 * Created by Sergii Iskov, 2023. Version 2.0
 */
public class day6b {
    public static void main(String[] args) {
        long time = Long.parseLong(timeData.split(":")[1].trim().replace(" ", ""));
        long distance = Long.parseLong(distanceData.split(":")[1].trim().replace(" ", ""));
        long count = 0;
        for (int holdTime = 0; holdTime < time; holdTime++) {
            long l = (time - holdTime) * holdTime;
            if (l > distance) count++;
        }
        System.out.println(count);
    }

    private static String timeData = "Time:        48     93     84     66";
    private static String distanceData = "Distance:   261   1192   1019   1063";
}
