package com.shpp.p2p.cs.siskov.adventofcode;

import java.util.Objects;
/**
 * This task "Day 2: Cube Conundrum" is from https://adventofcode.com/2023/day/2
 * We need to calculate the sum of the power of sets of all games.
 * Created by Sergii Iskov, 2023. Version 2.0
 */
public class day2b {

    public static void main(String[] args) {
       int power = 0;
        String[] gameArray = data.split("\n");
        for (int i = 0; i < gameArray.length; i++) {
            String[] game = gameArray[i].split(":")[1].trim().split(";");
            int red = 0, blue = 0, green = 0;
            boolean point = true;
            for (int j = 0; j < game.length; j++) {
                String[] sets = game[j].trim().split(",");
                for (int k = 0; k < sets.length; k++) {
                    String[] set = sets[k].trim().split(" ");
                    if (Objects.equals(set[1], "red")) {
                       red = Math.max(Integer.parseInt(set[0]), red);
                    } else if (Objects.equals(set[1], "green")) {
                        green = Math.max(Integer.parseInt(set[0]), green);
                    } else blue = Math.max(Integer.parseInt(set[0]), blue);
                }
//                System.out.println(game[j] + " : red = " + red + " ; green = " + green + " ; blue = " + blue);
            }
            System.out.println("Power of Game " + (i + 1) + " = " + (red * green * blue));
            power += red * green * blue;
        }
        System.out.println("Total power = " + power);
    }

    // input data
    private static String data = "Game 1: 4 green, 2 blue; 1 red, 1 blue, 4 green; 3 green, 4 blue, 1 red; 7 green, 2 blue, 4 red; 3 red, 7 green; 3 red, 3 green\n" +
            "Game 2: 1 blue, 11 red, 1 green; 3 blue, 2 red, 4 green; 11 red, 2 green, 2 blue; 13 green, 5 red, 1 blue; 4 green, 8 red, 3 blue\n" +
            "Game 3: 9 red, 2 blue; 4 blue, 2 green, 1 red; 7 red, 4 blue, 3 green; 3 blue, 6 red; 9 blue, 4 red; 3 red\n" +
            "Game 4: 5 blue, 11 green, 3 red; 6 green, 3 blue, 7 red; 17 blue, 9 green; 1 red, 5 blue, 3 green; 6 red, 7 blue, 4 green\n" +
            "Game 5: 3 green, 7 blue, 7 red; 6 green, 3 red, 4 blue; 7 blue, 4 red\n" +
            "Game 6: 1 green, 3 blue; 2 blue, 9 red; 2 green, 13 blue, 11 red; 7 red, 12 blue, 1 green\n" +
            "Game 7: 2 blue, 6 red, 12 green; 7 red, 8 blue, 6 green; 7 blue, 3 green, 7 red; 5 blue, 9 green, 13 red\n" +
            "Game 8: 13 blue, 1 green; 3 red, 9 blue; 3 red, 4 blue; 2 red, 3 blue, 1 green; 1 green, 15 blue, 4 red\n" +
            "Game 9: 1 green, 5 blue, 11 red; 2 red, 1 blue; 2 red, 5 blue\n" +
            "Game 10: 8 red, 20 green; 12 green, 1 red, 2 blue; 5 red, 3 blue, 7 green; 4 red, 19 green, 6 blue; 3 blue, 4 red, 14 green; 9 red, 15 green\n" +
            "Game 11: 7 green, 4 blue, 14 red; 7 red, 8 green; 6 blue, 6 red; 5 blue, 10 red, 11 green; 12 red, 2 green\n" +
            "Game 12: 4 blue, 5 green, 8 red; 2 green, 4 blue, 7 red; 4 blue, 3 green, 2 red; 2 red, 4 green\n" +
            "Game 13: 7 blue, 8 red; 5 green, 15 blue, 2 red; 7 green, 3 blue, 12 red\n" +
            "Game 14: 4 green, 16 red; 6 red, 2 green; 5 red, 1 blue, 3 green; 1 blue, 1 red, 2 green\n" +
            "Game 15: 3 green; 2 blue, 1 red, 2 green; 6 blue; 3 blue, 1 red, 2 green; 2 red, 1 green\n" +
            "Game 16: 13 green, 3 red; 9 green, 1 blue; 4 blue, 1 red, 18 green; 2 red, 3 blue, 7 green; 17 green, 2 red, 3 blue; 12 green, 2 red\n" +
            "Game 17: 2 blue, 4 green, 3 red; 2 red, 5 green, 11 blue; 5 green, 15 blue, 2 red; 3 green, 13 blue; 6 blue, 2 green, 2 red; 8 blue, 1 red\n" +
            "Game 18: 6 red, 4 green, 7 blue; 2 red, 3 green, 12 blue; 3 red, 6 blue, 6 green; 9 red, 10 blue; 6 green, 4 blue, 2 red; 12 red, 12 blue, 9 green\n" +
            "Game 19: 3 blue, 2 red, 3 green; 16 red, 3 blue, 5 green; 2 red, 6 green; 3 green, 2 blue, 15 red; 2 blue, 13 red, 1 green\n" +
            "Game 20: 2 blue; 1 green, 5 blue, 2 red; 3 blue, 2 red, 1 green; 1 red, 2 blue\n" +
            "Game 21: 15 green, 13 blue, 4 red; 9 green, 6 red, 19 blue; 6 blue, 1 green, 1 red; 1 red, 11 green, 9 blue; 3 red, 14 green, 8 blue\n" +
            "Game 22: 3 blue, 10 red, 1 green; 2 red, 6 green; 9 green, 3 blue, 4 red; 2 blue, 4 green\n" +
            "Game 23: 5 red, 2 green, 5 blue; 4 green, 12 red, 2 blue; 3 green, 8 red, 4 blue\n" +
            "Game 24: 1 green, 16 red, 3 blue; 10 red, 1 blue; 2 blue, 1 green, 7 red; 12 red, 1 green; 14 red, 1 green; 1 blue, 8 red, 1 green\n" +
            "Game 25: 8 blue, 9 red, 6 green; 2 blue, 4 green, 8 red; 1 green, 9 blue, 2 red; 14 red, 4 blue\n" +
            "Game 26: 4 blue, 3 green; 1 red, 3 blue; 6 red, 2 green, 6 blue; 5 green, 2 red; 5 blue, 5 green; 6 red, 1 blue\n" +
            "Game 27: 6 green, 9 blue; 1 red, 6 green, 8 blue; 3 green, 1 blue, 1 red; 3 red, 4 blue; 2 red, 2 blue; 4 red, 3 green, 7 blue\n" +
            "Game 28: 5 green, 2 blue; 5 blue; 1 red, 4 blue, 3 green; 1 green, 2 red\n" +
            "Game 29: 1 green, 2 red, 4 blue; 1 green, 2 red, 1 blue; 9 red, 6 blue\n" +
            "Game 30: 1 green, 1 red, 5 blue; 13 blue, 4 green, 2 red; 10 green, 11 blue; 9 green, 2 red, 12 blue\n" +
            "Game 31: 4 red, 5 blue; 8 blue, 1 red, 1 green; 4 red, 5 green; 3 green; 9 blue, 2 red, 7 green\n" +
            "Game 32: 5 blue, 4 red, 5 green; 10 red, 10 green, 5 blue; 10 red, 12 green, 6 blue; 8 red, 1 blue, 13 green; 6 green, 14 red, 2 blue\n" +
            "Game 33: 9 green, 6 red, 4 blue; 1 red, 2 blue, 13 green; 4 red, 4 green, 5 blue\n" +
            "Game 34: 1 blue, 1 red; 9 green, 14 red, 1 blue; 3 blue, 7 green\n" +
            "Game 35: 1 red, 11 green, 5 blue; 1 red, 5 blue, 17 green; 19 green, 6 blue; 4 green, 7 blue; 10 blue, 7 green\n" +
            "Game 36: 9 green, 6 blue, 4 red; 8 blue, 13 green, 1 red; 5 blue, 5 green; 15 green, 1 red\n" +
            "Game 37: 1 green, 9 red, 1 blue; 14 green; 11 green, 6 red\n" +
            "Game 38: 2 blue; 9 green, 1 blue, 8 red; 4 green, 1 blue, 3 red\n" +
            "Game 39: 7 red, 7 blue; 3 green, 6 blue, 2 red; 3 green, 4 red\n" +
            "Game 40: 5 blue, 2 red, 6 green; 6 blue, 10 green, 4 red; 8 green, 6 blue; 3 green, 2 blue; 2 red, 14 green\n" +
            "Game 41: 5 red, 14 blue, 3 green; 3 red, 3 blue, 7 green; 19 blue, 15 green, 6 red; 5 green, 18 blue; 1 green, 7 red, 9 blue; 14 green, 10 blue, 1 red\n" +
            "Game 42: 2 red, 3 green; 2 blue, 3 red; 15 green, 1 blue; 2 blue, 15 green, 1 red; 7 red, 15 green\n" +
            "Game 43: 4 green, 6 red, 9 blue; 4 green, 3 red, 18 blue; 6 green, 7 blue; 4 red, 7 blue; 8 blue, 7 green, 1 red; 5 red, 14 blue\n" +
            "Game 44: 2 green, 11 blue; 1 green, 5 red, 8 blue; 4 green, 17 blue, 4 red\n" +
            "Game 45: 6 blue, 3 green, 2 red; 8 green, 12 blue, 3 red; 13 blue, 11 green; 13 blue, 9 green; 2 blue, 3 green, 3 red; 2 blue, 10 green\n" +
            "Game 46: 14 blue, 12 green, 3 red; 2 green, 1 red, 10 blue; 5 red, 7 green\n" +
            "Game 47: 15 blue, 1 red; 1 red, 14 blue; 1 red, 16 blue; 3 green, 8 blue\n" +
            "Game 48: 1 green, 3 blue, 1 red; 8 blue, 2 red, 8 green; 14 red, 4 green, 11 blue\n" +
            "Game 49: 6 red, 5 blue, 2 green; 3 red, 11 blue; 1 blue, 14 green, 6 red\n" +
            "Game 50: 7 red, 7 blue; 7 blue, 7 red; 13 blue, 1 green, 2 red; 7 green, 5 red, 9 blue\n" +
            "Game 51: 4 blue, 9 red, 1 green; 16 red; 2 blue, 6 red; 11 red, 6 blue\n" +
            "Game 52: 4 green, 4 blue, 9 red; 5 blue, 4 red, 16 green; 16 green, 3 red\n" +
            "Game 53: 2 green, 12 red; 2 red, 5 green, 15 blue; 9 blue, 17 red, 9 green; 2 blue, 6 red, 4 green\n" +
            "Game 54: 2 red, 3 blue, 5 green; 8 green, 3 blue; 9 green, 3 blue, 3 red; 1 blue, 4 green\n" +
            "Game 55: 6 green, 11 blue, 12 red; 10 blue, 6 red, 13 green; 7 green, 9 blue; 10 green, 20 red, 7 blue; 9 green, 14 red, 8 blue; 14 green, 15 red\n" +
            "Game 56: 1 green, 8 red, 1 blue; 1 green, 3 blue, 13 red; 5 red, 3 blue; 5 blue, 16 red; 12 red, 4 blue\n" +
            "Game 57: 7 green, 5 blue; 13 blue; 1 red, 11 green, 4 blue; 1 red, 7 green, 5 blue\n" +
            "Game 58: 14 blue, 6 green, 9 red; 7 blue, 1 green, 11 red; 3 red, 9 blue, 6 green; 4 green, 2 red; 2 blue, 6 green; 11 blue, 1 red\n" +
            "Game 59: 6 red, 1 blue, 5 green; 4 green; 15 green; 7 red, 1 blue, 12 green; 7 red, 1 blue, 3 green\n" +
            "Game 60: 3 blue, 6 red, 2 green; 7 green, 6 red, 4 blue; 3 green, 1 red, 4 blue; 3 red, 1 green; 9 red, 5 green, 4 blue\n" +
            "Game 61: 1 green, 3 blue; 1 red, 2 green; 1 green, 2 blue, 2 red\n" +
            "Game 62: 10 green, 15 blue, 14 red; 11 blue, 11 red, 16 green; 5 red, 5 green, 12 blue\n" +
            "Game 63: 2 blue, 5 red; 7 blue, 2 green, 2 red; 2 red, 1 blue\n" +
            "Game 64: 9 blue, 12 red, 4 green; 5 blue, 13 red; 1 red, 2 green, 7 blue\n" +
            "Game 65: 4 blue, 8 red; 13 green, 8 blue, 5 red; 1 green, 5 blue, 7 red; 11 red, 7 blue, 10 green\n" +
            "Game 66: 8 red, 17 blue; 1 green, 9 red, 7 blue; 12 red\n" +
            "Game 67: 14 blue, 12 green, 3 red; 12 green; 9 green, 13 red, 15 blue; 2 red, 10 green, 1 blue\n" +
            "Game 68: 11 blue, 14 green; 14 green; 9 blue, 7 green, 1 red; 9 blue, 7 green; 17 green, 2 blue; 4 green, 4 blue\n" +
            "Game 69: 4 blue, 14 green, 6 red; 11 red, 7 green, 10 blue; 4 red, 8 blue, 8 green; 7 green, 6 red, 7 blue\n" +
            "Game 70: 12 red, 16 green, 11 blue; 16 green, 15 blue, 5 red; 10 blue, 1 red, 12 green; 9 red, 8 blue, 4 green; 2 green, 8 red, 3 blue\n" +
            "Game 71: 8 red, 1 blue, 5 green; 12 green, 7 red; 11 green, 1 blue, 7 red\n" +
            "Game 72: 5 green, 15 red; 7 green, 3 red, 4 blue; 10 red, 1 green; 6 blue, 15 red, 3 green\n" +
            "Game 73: 1 green, 5 red, 1 blue; 6 red, 3 blue, 6 green; 11 red, 1 blue\n" +
            "Game 74: 5 red; 1 blue, 3 green, 3 red; 2 green, 7 red; 1 blue, 2 red; 3 red, 1 green\n" +
            "Game 75: 13 blue, 20 red, 10 green; 3 green, 5 blue, 14 red; 9 red, 13 green, 7 blue; 1 blue, 15 red, 2 green; 11 blue, 2 green, 17 red; 11 red, 13 blue, 13 green\n" +
            "Game 76: 9 red, 7 green, 2 blue; 7 red, 2 blue, 8 green; 4 blue, 3 red, 9 green; 4 red, 1 green; 1 red, 2 green, 3 blue\n" +
            "Game 77: 5 red, 2 green, 15 blue; 12 green, 4 red, 2 blue; 10 blue, 6 red, 9 green; 7 blue, 3 green; 16 blue, 4 red, 5 green\n" +
            "Game 78: 11 blue, 3 green, 19 red; 3 blue, 1 red; 8 red, 14 blue, 3 green; 8 blue, 8 green, 16 red; 8 blue, 14 red; 12 blue, 11 red, 2 green\n" +
            "Game 79: 10 blue, 5 red, 1 green; 3 blue, 13 red; 15 red, 1 green; 4 red, 6 blue, 1 green; 1 green, 6 blue\n" +
            "Game 80: 7 red, 1 green, 1 blue; 1 blue, 4 red, 3 green; 2 red, 2 green; 7 red, 1 blue, 1 green; 2 red, 1 green, 3 blue\n" +
            "Game 81: 12 green, 2 red, 8 blue; 1 green, 1 blue, 1 red; 7 blue, 1 red, 11 green; 1 red, 12 blue, 4 green\n" +
            "Game 82: 18 red, 5 blue, 4 green; 6 green, 11 red; 11 green, 18 red, 5 blue; 4 green, 17 red, 4 blue; 5 blue, 14 red, 15 green\n" +
            "Game 83: 4 red, 6 blue, 6 green; 9 red, 4 green; 8 green, 7 blue; 2 blue, 9 red, 13 green; 2 blue, 9 green, 11 red\n" +
            "Game 84: 15 blue; 4 green, 1 red, 15 blue; 2 green, 16 blue; 3 green, 14 blue; 16 blue\n" +
            "Game 85: 3 red, 7 green, 8 blue; 3 blue, 17 green, 7 red; 13 green, 4 blue; 6 blue, 8 green\n" +
            "Game 86: 16 green, 6 blue; 12 blue, 9 red, 11 green; 17 green, 4 blue, 8 red\n" +
            "Game 87: 6 blue, 3 green, 13 red; 13 blue; 12 red, 2 green, 1 blue\n" +
            "Game 88: 6 red, 2 blue; 16 red, 13 blue, 1 green; 2 green, 11 blue, 2 red; 12 blue, 9 red, 1 green; 5 blue, 2 red, 2 green; 18 red, 3 blue\n" +
            "Game 89: 6 green, 5 blue; 4 green, 4 blue; 3 red, 5 blue\n" +
            "Game 90: 3 green, 8 blue; 2 green, 7 blue, 9 red; 8 red, 2 blue, 4 green; 1 green, 3 red, 7 blue; 4 blue, 4 green, 2 red; 9 red, 3 blue, 3 green\n" +
            "Game 91: 9 red, 12 green, 1 blue; 11 green, 9 red, 2 blue; 1 blue, 8 red, 4 green; 6 red, 9 green; 2 blue, 10 red, 1 green; 2 blue, 15 green, 13 red\n" +
            "Game 92: 3 green, 11 red, 16 blue; 8 blue, 1 red, 6 green; 4 green, 1 red, 5 blue\n" +
            "Game 93: 9 blue, 3 red, 13 green; 2 red, 9 blue; 3 blue, 17 green, 5 red; 4 green, 8 blue\n" +
            "Game 94: 2 blue, 3 red, 9 green; 4 blue, 1 red, 6 green; 8 green, 2 blue; 4 green, 2 blue, 7 red\n" +
            "Game 95: 5 green, 3 blue; 4 blue, 3 green, 8 red; 3 green, 4 red, 3 blue; 2 blue, 4 red; 9 blue, 5 red, 3 green\n" +
            "Game 96: 11 green; 10 green, 5 blue, 11 red; 5 blue, 13 red, 15 green; 10 green, 1 blue, 11 red\n" +
            "Game 97: 5 green, 6 blue, 1 red; 7 green, 1 red; 5 blue; 3 blue, 1 red\n" +
            "Game 98: 1 blue, 5 green, 7 red; 3 red, 5 green, 1 blue; 4 blue, 8 green, 2 red; 4 green, 1 blue, 6 red\n" +
            "Game 99: 12 blue, 8 green; 2 green; 3 red, 7 green, 5 blue; 1 green, 1 blue, 2 red\n" +
            "Game 100: 4 blue, 14 red; 12 red, 1 blue; 2 red, 2 blue; 8 red; 14 red, 2 blue, 1 green; 3 blue";
}
