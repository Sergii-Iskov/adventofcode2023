package com.shpp.p2p.cs.siskov.adventofcode;
/**
 * This task "Day 6: Wait For It" is from https://adventofcode.com/2023/day/6
 * We need to Determine the number of ways you could beat the record in each race.
 * What do we get if you multiply these numbers together?
 * Created by Sergii Iskov, 2023. Version 1.0
 */
public class day6a {
    public static void main(String[] args) {
        int multiplyResult = 0;
        for (int i = 0; i < time.length; i++) {
            int l = 0, count = 0;
            for (int holdTime = 0; holdTime < time[i]; holdTime++) {
                l = (time[i] - holdTime) * holdTime;
                if (l > distance[i]) count++;
            }
            multiplyResult = (multiplyResult == 0) ? count : multiplyResult * count;
        }
        System.out.println(multiplyResult);
    }

    private static int [] time = new int[]{48, 93, 84, 66};
    private static int [] distance = new int[]{261, 1192, 1019, 1063};
}
