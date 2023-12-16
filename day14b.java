package com.shpp.p2p.cs.siskov.adventofcode;

/**
 * This task "Day 14: Parabolic Reflector Dish" is from https://adventofcode.com/2023/day/14
 * We need to calculate total load on the north support beams after 1000000000 cycles (N-W-S-E).
 * Created by Sergii Iskov, 2023. Version 2.0
 */
public class day14b {
    private static final int CYCLE = 1000000000;

    public static void main(String[] args) {
        String[] dataArray = data.split("\n");
        StringBuilder[] dataSB = new StringBuilder[dataArray.length];
        for (int i = 0; i < dataSB.length; i++) {
            dataSB[i] = new StringBuilder(dataArray[i]);
        }

        for (int i = 0; i < CYCLE; i++) {
            rotateN(dataSB);
            rotateW(dataSB);
            rotateS(dataSB);
            rotateE(dataSB);
            System.out.println(i);
        }

        int result = 0;
        for (int i = 0; i < dataSB.length; i++) {
            int count = 0;
            for (int j = 0; j < dataSB[i].length(); j++) {
                if (dataSB[i].charAt(j) == 'O') count++;
            }
            result += count * (dataSB.length - i);
            System.out.println(dataSB[i] + " = " + count * (dataSB.length - i) + " (line " + (dataSB.length - i) + " )");
        }
        System.out.println(result);

    }

    private static void rotateN(StringBuilder[] dataSB) {
        for (int i = 0; i < dataSB.length; i++) {
            for (int j = 0; j < dataSB[i].length(); j++) {
                if (dataSB[i].charAt(j) == 'O') {
                    checkPointN(dataSB, i, j);
                }
            }
        }
    }

    private static void checkPointN(StringBuilder[] dataSB, int i, int j) {
        if (checkInBorder(dataSB, i - 1, j) && dataSB[i - 1].charAt(j) == '.') {
            dataSB[i].setCharAt(j, '.');
            checkPointN(dataSB, i - 1, j);
        } else {
            dataSB[i].setCharAt(j, 'O');
        }
    }

    private static void rotateS(StringBuilder[] dataSB) {
        for (int i = dataSB.length - 1; i >= 0; i--) {
            for (int j = 0; j < dataSB[i].length(); j++) {
                if (dataSB[i].charAt(j) == 'O') {
                    checkPointS(dataSB, i, j);
                }
            }
        }
    }

    private static void checkPointS(StringBuilder[] dataSB, int i, int j) {
        if (checkInBorder(dataSB, i + 1, j) && dataSB[i + 1].charAt(j) == '.') {
            dataSB[i].setCharAt(j, '.');
            checkPointS(dataSB, i + 1, j);
        } else {
            dataSB[i].setCharAt(j, 'O');
        }
    }

    private static void rotateW(StringBuilder[] dataSB) {
        for (int i = 0; i < dataSB.length; i++) {
            for (int j = 0; j < dataSB[0].length(); j++) {
                if (dataSB[i].charAt(j) == 'O') {
                    checkPointW(dataSB, i, j);
                }
            }
        }
    }

    private static void checkPointW(StringBuilder[] dataSB, int i, int j) {
        if (checkInBorder(dataSB, i, j - 1) && dataSB[i].charAt(j - 1) == '.') {
            dataSB[i].setCharAt(j, '.');
            checkPointW(dataSB, i, j - 1);
        } else {
            dataSB[i].setCharAt(j, 'O');
        }
    }

    private static void rotateE(StringBuilder[] dataSB) {
        for (int j = dataSB[0].length() - 1; j >= 0; j--) {
            for (int i = 0; i < dataSB.length; i++) {
                if (dataSB[i].charAt(j) == 'O') {
                    checkPointE(dataSB, i, j);
                }
            }
        }
        // uncomment to see current results after every cycle
//        int result = 0;
//        for (int i = 0; i < dataSB.length; i++) {
//            int count = 0;
//            for (int j = 0; j < dataSB[i].length(); j++) {
//                if (dataSB[i].charAt(j) == 'O') count++;
//            }
//            result += count * (dataSB.length - i);
//        }
//        System.out.println("----------------------------  = " + result);
    }

    private static void checkPointE(StringBuilder[] dataSB, int i, int j) {
        if (checkInBorder(dataSB, i, j + 1) && dataSB[i].charAt(j + 1) == '.') {
            dataSB[i].setCharAt(j, '.');
            checkPointE(dataSB, i, j + 1);
        } else {
            dataSB[i].setCharAt(j, 'O');
        }
    }


    private static boolean checkInBorder(StringBuilder[] dataSB, int y, int x) {
        return x >= 0 && y >= 0 && x <= dataSB[0].length() - 1 && y <= dataSB.length - 1;
    }

    private static String data2 =
            "O....#....\n" +
                    "O.OO#....#\n" +
                    ".....##...\n" +
                    "OO.#O....O\n" +
                    ".O.....O#.\n" +
                    "O.#..O.#.#\n" +
                    "..O..#O..O\n" +
                    ".......O..\n" +
                    "#....###..\n" +
                    "#OO..#....";
    private static String data = ".#....#.O##O....OO#O..O##.O.O..#..O...OOO.#..................#...#O#.##.#.....###O...#OO...#...#....\n" +
            "......O........O....O##..O#..O.O#.....O.....O...#.O...O...#...#O......#O.O##....#OO...#...O....O....\n" +
            ".##O.O...O......O.O............O.O.O.....O.#O.O#.#..#O.#..O..OO.....OO..#..#.O#...O..OO......#.#....\n" +
            ".O.O.#...##.O.#.......#.#.......#O#..#O.....OOO.OO.........O.#.#.O......#...#...#....O..O....#..###.\n" +
            "#..#..#..#.#.O....O.O.OO....#.O...O.O.#O....#.#.O....#O.#.O#.......#..O.##O....O..OO.###O....#...OOO\n" +
            "...............OO#...####.......O...O##...........#.##O....#O#O.##O##..O.O.....O.O..O#...O...#...O.#\n" +
            "..O..OO.O...##....O#...#..OO.OO#......O.#.#O#..##...O..#O...O..#......O....O.#..#..O.O#O#.#....#....\n" +
            "....##.#..#...O......O...O..#....#.#.O......##.##OOOO#........O#..OO#OO.O.......O..O...O.O....##.#..\n" +
            "O..O.###...OO....#.#OOO..##.OO.#......OOO..#..O.O....#O.#..O#.O.....O..#...O..O#....#O.OOO..O.OO.#..\n" +
            ".....#......O#OO...O.#..O.#.O.O..#O..O...O#O...O....O###..#.........O..OO#.O...O.O......O.O.......#.\n" +
            ".......#....#....O......O....O.O#.#.......#.O..O..##.O..O..O...O..##.#...O...OO.##....#OOO#O.#####.O\n" +
            ".O..O.....O#..O#....O.OOOOO...#...O.#O..#O..O........O.....#O..##..#........#.OO.O..O...O.OO..OO....\n" +
            "........O..OO.#..#.O...#.O.#O#.OOO...O#OO#..O.OOO.....#O.O.O.OO..........#.....O.O.....#O.O.....#O#.\n" +
            "......OOO#...O.#O#.O.O#.O.#..OOO#.#.......O.##.O.#O#...O#.O....#.O#....O.##..#.#....OO.O.OO..O.OO...\n" +
            ".O.O.OO.#.#O...#...#.#...O.#.........O..#O.O........#.O...#...O.O.O#.....O#.O....O...#...O#...O.#...\n" +
            ".O....O.....O.O....OOO..O#...O...#.O.....OOO..#.O.#.O.O....O.OO.O.#..#O..OOO...O.......O..#.#.....O.\n" +
            "#O###..O#.....###......#...#.#...OO...O.#.....#..#O....O.O...O#....O.....#...#...............O......\n" +
            ".O.OO#O..O.OO#.#O#..#.O.##.##O.....###....O.......O#.#..#.....##...O..#...#.O.O##..OO..O.OOOO...O..#\n" +
            "..#.#.#..OO...#.....O.......#.OO.#.O.#O.O###.###.O......O...OO..##.O#.O....O..O..O..#.O..O.O...O#.#.\n" +
            "#O.O....O....O.O......#..O.O...O.O#.O....OO#.OO.O...#.....O#..O.O#..#.#..........O..O....OOO...O..O.\n" +
            ".#O...........O#....O..#O.O.#...#....O..........###...#........#.O.#..O#.O...O.#.....###.....##...O#\n" +
            "..O.O..##.#O...O.#..O....O#....#...O.O...O.O........O.#.O..O....#.##...O.#OOO.#....O..............#O\n" +
            ".#....O....OO.#.O....O#O#...OO##....#.#......#O.#..O..##.O..#.##.#.O..#...O...##O......#.O.#.##..O#.\n" +
            ".O#..#.O.#...O.OO...#.........O.....#O..........#..O#......#.O##.#.....OO....##OO...O.#.O.OOO...O.O.\n" +
            "O..#....O.....OO.#O.....#....O.........O....O.O.O..#....#..O........#.#.O#.##..#...O#O....#...O#.#O.\n" +
            ".#...OO#..O...#.#O..#.O....#.#.#.....##....O..O...#.O.O........O.#.O...O.O............#.......#.O...\n" +
            "...#.O....O.....#...#..O.OO...#O.OO....O##.OO#...O............O.....O............#O.OO...O#...#....#\n" +
            "..#O#.O.OO....O....O.....#..O...O...O..O#....OOO..O.#O.#O.......O..#.OO...#O##O..##..O...##..#...O..\n" +
            ".....O##...#O..O....#...#..#O......#.#..O#.#....O..O.#....OOO.O..O.O....##..#O..#..#....#O..........\n" +
            "...#............O.O#......#.O.O...OO.....OO.....O..O..O.#O.O.#..O.O.O.O....O..O...OO..O.OO...##...O.\n" +
            "O.O......O...#....OO.#..#..#....##.#OO.....O.#OO.OO.O..#O.O#......##.#..O#.#O..O....#O....OO#...##OO\n" +
            ".......O....#..OOO..#.#...O.....OO.OO.#..#...#O....O..O.....O..#...O......#....O.#.....O....#....#O.\n" +
            "..#OOO.....#.O..#....#OO.#O.....O.O...#...#O#.......#....O...##..O...O...O.O...O..#.....OO#.OO.O..O#\n" +
            "#..#.#.O#.O..O..###..#.....O.O#...#.O...#.O#..#O.OO..O.#.#..O.#.#.#....##..OO##.....#.....#.O...#...\n" +
            "#O.O.O...OO#....O....O##......#OO#.O.OO.OO#O..O..OOO.....O..#O.#..#O..O....#...OO....##OO#O...#.....\n" +
            "#.#.....O..O..O.O#.O........O........##..O.......OO...O..#...O#.O.O.O.O#.O..O#.....OOO.O.#...#O.O..O\n" +
            "O...OOOO.###.O.............#...O..........#.#........###OO.....#....O....#O...##..O...O#..O.O..#..#O\n" +
            "..O.#O.......O..OO.O...#....#O.#...#....O.O...O....OO.........O....OO.........OO#..#.##..OO.#.#..O..\n" +
            "......O.O.#O..O....OO#....O...#..O#....O###..OO.O........O.O##....##O.O.O......O.#....##O.#..O.#.O.#\n" +
            "....O....##.#...OO#.#....#....O.#.##....#..O..OO..OO....OO...OO.#O#......#O#...#O.....#.O#...OO.O...\n" +
            "..O####...........O.O.......OOOO...OO#.....#......O..O...O..OO..#..O...#O#..#.#O#O#...###..#O..#....\n" +
            ".......O#..#.O.#.......#.O.#O.#..#OO#O....##..#...O..O##...#.OO.O.O.O.O....O.O...#.#.....OO...#.O...\n" +
            "O.#.....#...O...#...#.OO.#O..O.#...O.O...O#O..##......#.#.....O...#......O##...OO......O.OO....#.#O#\n" +
            "##O#.O.......#.......#..O.O..O.##...O....#......O.#....O...O....O.OO.O.O......#OOO.O#O.##..#O.O..#.#\n" +
            "O#...O.....#..O..#O..O#....##.#.O.....OOOO....O.#.................#O.O..OO.#OO.#.....#.#.#...#...O..\n" +
            "O.OO.O....#..##...O.#O......O#..#..#...O....#O#.O.O......#..O.#O#...O...#O....O..#O#O.....#.#OO...O.\n" +
            ".#.O###..O#O...#.....#..O....O.O#O...O.....O.##..O#.#...#..#O...#OOOO#...#.#O#....O....#O.#..#O.#O#.\n" +
            "#....O.OO.O.......#....#..OO.O.....O..#.......OO....#......O##..O..O#..O....O..##..O..OO..#.O..#...#\n" +
            "##O#.#.O....O........OO........O#.#.#O......#...O#O...OO##.........#.##.##......#.O...O.OOO..#..O.O.\n" +
            "...........O.##.O#.O.#OO#O.#O...###...O.O.#...O...O.#....#.#....OO#.#......O..#..O.O.#.......O.#.#..\n" +
            ".OO...O...........#.O....O..O..OO..O.....O.O...O#.OO....#OOOO....#.O.#.#.O#.O...#.O....O#...##O.....\n" +
            "...........O.#...#...O..#..O..#..O..O.O.........#O.OO..O.OO.....O.O........OO..O...O....O.O..#OOO...\n" +
            "O#.O##.O.OOO.O#.##........O...OOO...#...OOO....O#.....#.OO..#..O#.....O#.O...O...#.OO.O#..##...OO#..\n" +
            "....#.O....O.O.O#.O#O...O.O.O.O..OO.O#...#.OO..O#...O.#...O..#...#..#.#O..OOO.O.OO.........#.O.O..O.\n" +
            "...O....OO....##...O..O.#O...O.#.#...OO...O....O.O#.#.O...#.O#O...O.....O....O.#O...O...............\n" +
            "..#..O.#..O.#....O.O.O...O#...O....O.OO..#.OO#....O..O.O..O....OO...OO........#....OO..O......O.#...\n" +
            ".#.O#.#OO##...O..O..#...##..OO....OO...O..O..#......O.O..O#...#....OO.#O.##......#...........O#O....\n" +
            ".#...#OO.O..#..#.O.OO#.#...#.##...O...#O....#..#O.#.#.OO.#..O..O.#...O#OOO..O...#.O.O....#...O..OO..\n" +
            ".###O.O.#O#.O....O#.#...O....#...O....OO##.#.#...O.......O.#O.....#...#O...O..O........#O..O..OO...O\n" +
            "O#.O...OO....#.##OOO.....O..OO........#.O..O..OOOOO#O..#O.#.#.....OO.O#.#..OO...O.O.OOO#O.#..#....O.\n" +
            "...#.#O..#..O.O..#.....#OO.O.OO####...##...O..O..###.O.#.#.O......O.O.#..#..##....OO#.##.O.O.O.OOOO#\n" +
            "...O#.....OOOO...O.##.O....#.#O.O#.###..#..#O..O.OO......#..#...O#.....OO.O##.O.O....#.#O.......O...\n" +
            "#...#....#.....#O....#.....OO.#..OO.##..#O..O.O.....O.O.OO.O#O..#....O....###...O........#OOO...O...\n" +
            ".O...O#O.#..#O..#OO.O...OO##O.#O.#.#..#....##O..O...#.OOO..#..#.........#O.#...OO......O.#..........\n" +
            ".#.OO#..O.#.O.....#...#....##O#.....###O.O....##...#...O.......OO#......#....#.OO.#OOO#.#....#O.O.OO\n" +
            "...#.O.O.O#...#....#....#...O#..#.O#...OO#...O##O..##.#O...#.OO..###.O...O##O..O..O.OO...O..###.#...\n" +
            "#O...O...#...#..#..O.O.O..#O...O.O#....O#..O................O....O..O......#.....##.#O..OO..O#..OO..\n" +
            "#..O.#.###.#.#...#..O....OO..###O...O.OO..........#..O.O..O..O.......OO#O....OO..O.O.##.#O#...OO...#\n" +
            "...O..O.#O..#OO...###OO.O....##O....O...O...........#O##.O.#..O.O.#..OOOO.#..O..O#.O........#.#OOO..\n" +
            "...O##OOO.....O.#.....O.#....#O.O...O#.#..O....#.OO..O#...OO.#.O.OOO.#..O#...O.......O#O.O#O...O....\n" +
            ".#....O...O#..........O...O.O.....O..#O..#OO.#...............##....O#O#....OO.###O....#.........###.\n" +
            "...OO.OO.#.......OO#.#..O..O....OO.##O...O.#.#..O##.O.O....OO.O..O.#..O..OO.#..O##.#..##.#...##..OO.\n" +
            ".......O........#...O.##..#..O#O...O..O.#.#O..#..O......OO..O.#....O...O......OOO....O.#.#....#O..#.\n" +
            "#..#....O..OO.#...#.O...O##.O#.O##..OOO.....OO..O#..#....O......OO...O.O......#.O..#..O....#....O...\n" +
            "...#.OO##.....OO...O......#.#..#..O#..O...O.O.O.........#..#.........O##..#.O..#..#....#..O......#..\n" +
            "O.#...OO..#..O.#.#OO#....##.OO#...O....#.#..#....#..OO..#O..O...O#..O..##..O#....O..O#...##...O....O\n" +
            "#.#.#.O.#O....O..#..#..O..OO.OO.#O.#..O..O....O.............#.O#...O#..#O.....O......#.......#...O..\n" +
            "....O.....##...O.#O.##.#.##OO..#....##O#.OO#.#..#..O##.#.#.#O.OO.#...O#..O.........O.##...##....#..#\n" +
            ".O#.....###....#.OO#..O#....#.....O.O#O#..#O.....#....#...O...O..##.#.O...OO#.##..O.O...#..........#\n" +
            ".OO..##......#O......#.O.O..O.##O.....O....#...O#.O..........O..#.O..#.......O....O.#...O.O.#.OO.O..\n" +
            "..#...O...#..#O.......O#..O..O#.#O.#O.#O#.#....O.#..O.O..#.#.O#...#.#.....#..OO.....O.#....O#.#..#..\n" +
            ".O.##.O..OO........#.#..O..O.......OO.O.OO.....O.#.###O...#OO.....#O.......O.O.O...O..O.............\n" +
            "OOO...OO.......O......O#O..#.#.O..OO#.#OO.....#....#OO.#...#.....OO.O..O#...#O.....O....O.#O#.......\n" +
            "..O.....O....O.O...#..O...O#....O.O.#.....#...O#.....O.....O#.O.##...O.O............O....O##.#O..O.O\n" +
            "....O..##O..O..O....#.....#.O.#.......#O...##.O#...OO.......O....#OO.O..O.O...O#..#......O...O..#..O\n" +
            "...#.O.....#.#.O...O#.....#.O..OO.O....O..#.O#.O#.O..#....#.........O..OO.O.O.O....O..#.OO...O##..#O\n" +
            ".#....#..........O.##..OO#...O...#...O..#.O#..O...#...#O#.O.......#.#..O#O#..#O..O#....#.....OO.O...\n" +
            "..O.O..O.##...O..#.OO#..O.O.....O..OO#.OO.O...O....O#...##OO..#O....##.#OO#......#.OOO.....#O..O..#O\n" +
            ".#....O##..O..#.O.#....OO#O..O..#..O.O.....#O..O##...O.....O....#.#.O###.O#...O.#..#.O......O.....O.\n" +
            "O.......O.#...#....O...#....#.....O..#.#O..O#....##O.O#........OO.#......O..OO....O##O.O#.O....O..O#\n" +
            ".#O.##.#O...O#...##.O....#O.#O#.#O.O.O#OO..O.#...O....#.....OO.#.......#..O.#..OO..O..OO.....O.....O\n" +
            ".O#..#OO.O...O#O.O..#..O.##.....##...O.#O.O....OO.#.OO#OO.OO......#.#..#.......O..O..OO#...#.....#.#\n" +
            "O#O.##....#.OO.O......#..O..O.OOO..#.....O.O.OO#.OO....#.O#O....OO.....O.O....#..#.O#.....O...O.....\n" +
            "O.O.#....O..#O#O#O...##...OO#O....O..OO..........#...O##.#....O.O...##O.#O#.O#O.O.#OO.#..OO..O......\n" +
            "...OO####O#..##..#O.O...O..O..OO...#..O..O......O...O#O..O......#OO#.OO..O.#...#.#...#....O........#\n" +
            ".....O.O...O.O#......#.#....#..O..O...OO..O.#.#..###....#.##......#....OOO.......O.O....#.#O..OO...#\n" +
            "....OO....OO...#....O.#O..........O..#..O.#O#.....#.#......#O....#..#........#O.#.....#.O..OOO#O.#O#\n" +
            "O...O...#..O....O#...#..#.O...#..#..OO.##..##O...O#..#..##.##.OO..O..#O...OO..........O..#.#O##...O.\n" +
            "#O.#...#......#OO..O.#...O.#.....O.....##.O....OO#..O..O...#.OO......O.....#OO.........#...#........\n" +
            "..##O.#..#.#.#O...OO......#O.#.O...O.#..#O..#.O....O....#.O#............####...OO.#..#O.O..#.O#.#O#.";

}

