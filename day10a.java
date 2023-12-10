package com.shpp.p2p.cs.siskov.adventofcode;

/**
 * This task "Day 9: Pipe Maze" is from https://adventofcode.com/2023/day/10#part2
 * We need to find farthest point from start position.
 * Created by Sergii Iskov, 2023. Version 1.0
 */
public class day10a {
    private static int step = 0;

    public static void main(String[] args) {
        String[] dataArr = data.split("\n");
        String[][] maze = new String[dataArr.length][dataArr[0].length()];
        int currentRow = 0;
        int currentCol = 0;
        for (int row = 0; row < dataArr.length; row++) {
            for (int col = 0; col < dataArr[0].length(); col++) {
                maze[row][col] = "" + dataArr[row].charAt(col);
                if (maze[row][col].equals("S")) {
                    currentCol = col;
                    currentRow = row;
                }
            }
        }
        System.out.println(maze.length + " * " + maze[0].length);
        fistStep(maze, currentCol, currentRow);
        System.out.println("Finish");
        System.out.println("farthest point = " + step / 2);
    }

    private static void fistStep(String[][] maze, int x, int y) {
        String key = "";
        System.out.print("Start - ");
        if ("\\|F7".contains(maze[y - 1][x])) key = "Up";
        else if ("-FL".contains(maze[y][x - 1])) key = "Left";
        else if ("7-J".contains(maze[y][x + 1])) key = "Right";
        else if ("\\|LJ".contains(maze[y + 1][x])) key = "Down";
        findWay(maze, x, y, key);
    }

    private static void findWay(String[][] maze, int x1, int y1, String key) {
        int x = x1, y = y1;
        String newKey = key;
        while (step == 0 || !maze[y][x].equals("S")) {
            step += 1;
            System.out.print(newKey + "(" + (step) + ")" + " - ");
            if (newKey.equals("Up") && isInMaze(maze, x, y - 1)) {
                if (maze[y - 1][x].charAt(0) == '|') newKey = "Up";
                if (maze[y - 1][x].equals("F")) newKey = "Right";
                if (maze[y - 1][x].equals("7")) newKey = "Left";
                y = y - 1;
            } else if (newKey.equals("Right") && isInMaze(maze, x + 1, y)) {
                if (maze[y][x + 1].equals("-")) newKey = "Right";
                if (maze[y][x + 1].equals("J")) newKey = "Up";
                if (maze[y][x + 1].equals("7")) newKey = "Down";
                x = x + 1;
            } else if (newKey.equals("Down") && isInMaze(maze, x, y + 1)) {
                if (maze[y + 1][x].charAt(0) == '|') newKey = "Down";
                if (maze[y + 1][x].equals("L")) newKey = "Right";
                if (maze[y + 1][x].equals("J")) newKey = "Left";
                y = y + 1;
            } else if (newKey.equals("Left") && isInMaze(maze, x - 1, y)) {
                if (maze[y][x - 1].equals("-")) newKey = "Left";
                if (maze[y][x - 1].equals("F")) newKey = "Down";
                if (maze[y][x - 1].equals("L")) newKey = "Up";
                x = x - 1;
            }
        }
    }

    /**
     * Check if current char is in the border of Array
     *
     * @param arr boolean array
     * @param x   coordinate x of char
     * @param y   coordinate y of char
     * @return true if char is in the border of Array
     */
    private static boolean isInMaze(String[][] arr, int x, int y) {
        return x >= 0 && y >= 0 && x <= arr[0].length - 1 && y <= arr.length - 1;
    }

    private static String data = "F7-FJ77FL|-L.7.FJ77F-7FF|7-F7F|--F7F-F7.-F---7L7FL7L77-7.F-7F-7FF.--.777F|.7.77-F-7F-LJ7F7F77.F.FF-7|-J-F|F--J--7J7.7--7-LF-J7J7.7.-L-FF77.|\n" +
            "F7-J||7JJ|FLF7.---|7J|7.||7L|-|-|LF7-FJL-|-|F7-J7.7LLJ-|--7LLLL-|F|FF7LLJJF|-LJ.||F-7J.|-JJ|JF|FJ.FLJJ7FL|J-JJ|.|FL|-7JJ|L|J7F-F-|77L7L|LJ7J\n" +
            ".|77LLJ.F-|.FJ7.FLLJF-J-7-J7.FJ-J-LJ.7-L7|-F|J|F-7..|LFJ7LL7.|.-.F7--L7LL--7J||.F-|-L-F|LJLJFFJ|7FJ.--FJ||L7-F|-77JL|J|.7-F7L..F--J--7-F-F7.\n" +
            "JJFJ7FJF7.L-|F77L-F|J||-JJ|7J|L7J||.L|-LLL-7J.|-J7-FJ.77|FLJL7JL7JF7L|7|.F|L--7.|J|JL-LJ.|.L---FFLF-.|.|FJF7JF7F||.FJ.LL|LL|--7JLJLF-J-LF-L7\n" +
            ".-JFL|L7LJ|7|LJLJ-FL--J..|JF-7-J.F-J7J-LL-FFF7.F|FF--LJJLJJ77.|-|||7L7J77FL7||.L7F7.L7-7-77-|7LF7.F-7J77L-FF7|LFFL-|.F7-|JLL7.|7|LLJJLF7L7LF\n" +
            "|-LLJ..7-FL7-L7-FFFJF777FF..-J-L.L|F-FF.FF-J||7-LFJ--|7.||.F77LF-7-7.LJJ7|LL7J77F7F-FJ7..F.|F7|L|F-JLLFL7|FF-7F77|..7-J.L7FL|-FJ-.LL7.L-7FF-\n" +
            "||7..F7J.LJL||7.L-.7JJ--JL777|-J.--F7LLL77|FJL77||J|..|FF-77F7-L7||F77LFJJ-||.|7JLJ-|-7F-J-F7F7-|77.F7LJ7FFL7||L-7FF7J7F7L-7|-|7|.-JFF.FJJJ.\n" +
            "F-77.7|F-.||F.LF7JF|-J7||F-7LJFL|.LJ-7JJLF7L7FJ77L7FLFF-L7L7F77L||FJL7F||J.J-.JJFL77LJ.|LJ.|||L7JLL7LJ|-F7F7|||F-J7JJFF-J7LFFJ|--7|-||77-|.7\n" +
            "L7L-LJ|-F-7FJ.|F7-LJFJ-L7J-F-F7.|.-JL|.FL|L7||F7F-7-JLJ-FJFJ||F-J|L7FJF77-||LF|L|.F7FF--77F|LJFJ||LFJ|J.|||||LJ|FF|.L|L-J77LLFJ77|7-LFJJFFJ7\n" +
            "|-L7FF7.J-J-.F7L|J7F--7-|.7|L||-7-|-F|7-FL7LJ||LJFJ7.||LL7L7||L-7|J|L-JL7-|F7F7--FJL77-||FFL7FJ|LL-|.7JF|LJLJF7L7F-7J|7|.|-F7LJJ|.L-FJL7-|L7\n" +
            "L-J|7J.F.7JL-LF-J.F77.LFF7F7FJ|J|.F.FJ|-F7|F7||F-J|FFF7|||FJ||F-JL7L-7F7L7FJ||||JL7FJJ.FLF7FJL-7|LFF7F-7L-7F-JL7||FJ-|-|FF7L|.L-JF|-|-J.LL7|\n" +
            "F7F|J..|-7.|F7.|JFJ|F-F-JLJ|L7L7FFF7J||.||LJ|||L-7F7FJ|F-JL-J|L7F7L7-||L-JL7LJL7F-J|F7.|J||L7F-J77F||L7L7.LJF--JLJ|F7F7-FJ|.JJ..L77-JJF7-|LL\n" +
            "JLJ.F--|-JF--F.LF7-||FL7F-7L-JFJF7||-F7FJ|FFJ||F-J|||FJL--7F-JJLJL7|FJL7F7FL7F-J|F-J||F7FJL-JL7F7F7|L7|FJFF7L--7F-J||||7L7|.|J.-JF-7JL777-7L\n" +
            "|7LFF7FJF-7F-7JJL|.L-F-||-L-7FJ-|LJ|FJ||FJFL7||L7FJLJL7LF-JL7F-7JFJLJF-J|L-7|L--J|F-J|||L7F---J|||LJFJ||LFJL---JL7-||||F7||7.LJL|L7L7JLLJ.|J\n" +
            "LJ.L|7.||.|L-J|FFJF7J|FLJF-7|L7FJF-JL7LJ|F--J||FJL---7L7L-7FJ|FJFJF--JF7L7FJL7F--J|F-J|L7||7F7F||L-7|FJL7L---7F--JFJLJLJLJL-7-.FLLFJ|LFJF-|J\n" +
            "L.F.F--JLJ-JF|-FF-FF7J|L.L7LJFJ|FJFF7L7FJL--7|||F7F--JFJF7|L7||FJFJF7J|L-JL-7|L7F-J|F7L7LJL7|L7|L7|||L-7L7LF7||F7.|F-----7F-J.F|LL|L7|.LJJJ.\n" +
            "FL--L|.F||..|L7|LFL||77|FLL-7L7|L7FJL-JL7F7J|||LJ|L-7FJFJLJFJ||L7|FJ|FJF7F--J|FJL7FJ||-L-7FJ|FJL7L7|L7.L7L7|LJLJL-JL7F7F7LJ||FF-F-J-FF-FJ.L7\n" +
            "LJ7FL|-F777L|-7FFFFJL-7F7JF7L7||FJL----7LJ|FJLJF-JF-J|7L-7FJFJ|FJLJFJL7|LJF--JL-7||FJ|F7FJL-JL77L7||FJF-JFJL--7F---7LJLJL---77LJJFJFJJFJ.F7|\n" +
            "F|7-7J.L7.LJL.LF7FJF--J|L7|L-JLJL7F-7F7|F-JL-7FJF7|F7L7|FJL7L7|L-7FJF7|||FL----7LJ|L7|||L-7F--JF7|LJL7|F7L7F7FJ|F-7L-7F7F7F7|J-J..|J.||J-J77\n" +
            "FJJ.F7..|-|-LF7|||FJJF7L7|L7F-7F-JL7|||||F7F-J|FJ|LJL7L7|F7L7|||FJL-JLJL7F7F7F7|F-JFJLJ|F-J|LF7||L-7FJLJL7||||FJ|FJF7LJLJLJLJ.LF7F7-L-J7J.L.\n" +
            "7FLFJL.|77FF-JLJ||L7FJ|.|L7LJFJL77FJ||LJ|||L-7|L7L7-FJFJLJL7LJ|FJF------J|||||LJ|F7L--7|L-7L7||||F-J|F7F7||||||J||FJL7-F7-|-JF|.J|L-7.|J7|J7\n" +
            "77---.-FJ|JL---7||FJL7|FJFJ-FJF-JFJFJL-7LJL7L||-L7L7|FJF7.FJF-J|FJF-7F7-FJ|||L-7|||FF7||F7|FJ||||L-7LJLJLJ||LJ|FJLJF-JFJL7F7LLL7LJ|.L|-.J|F|\n" +
            "L|-J7FJL7J7|F-7||||F7||L7|F7|FJF7L7|F7JL-7FJFJL7J|FJ||J|L7L7|F-JL7|FJ|L7L7|||F7|LJ|FJ||LJLJL7|||L7|L7F----J|F7|L7F-JF-JF-J||.LLJ..L..J..F-77\n" +
            ".L|F-7FFJJFFL7|||||||||F|||||L7||FJLJ|F7FJ||L-7L7|L7|L7L7|FJLJF7FJ||JL7|FJ|||||L-7||FJL-7F--J|||FJF7||F7F7||||L-JL--JF-JF7|L7-JF-.|FF|L-7--7\n" +
            "FFJ--7J.FFFF-JLJLJLJLJL-JLJ||FJ|||F--J|LJFJF7|L7||FJL7L-J|L7F-JLJFJL7-|||FJ|LJL--J||L-7FJL7F-JLJL7|LJLJLJL7LJ|F----7FJFFJ||FJ-|L|7|7.LJ||.LL\n" +
            "FJJ7.|J7F-FL-7F-7F7F7F7F7F7||L7|||L7F7|F7L-J|F-JLJL-7|F7FJ||L7.F7L-7L7|LJL7L--7F-7|L7FJL-7||F----JL--7F---JF-JL---7LJFFJFJ|L-777LLF|FJFLJ7.|\n" +
            "|.FF-|.FJF---J|JLJLJLJLJLJ|LJFJ|LJFJ||LJL--7|L-7F---JLJ||F7L7L7|L7.L7||F--JF7FJ|FJ|FJL77FJ||L7F-77F7FJL7|F7L-7F---JJF7L7|L|F-J-7F|.|J.-LF7J.\n" +
            ".FFLFJF-7L----JF-7F-7F7F-7L-7L-JF-JFJ|F7F--JL7F||F7F-7FJ|||JL7||FJF7|LJL7F7|||FJL7|L-7L7L7||FJ|FJFJ|L-7L7||F7|L-7LF-JL-JL7|L7|J|77-F.7LLL-.|\n" +
            ".FL7--L7L-----7|FJL7|||L7|F7L7F7|F7L7LJ|L---7|FJLJLJFJL7LJL-7|LJL-J|L--7|||||LJF-JL-7L7L7|LJL-JL-JFJF7L7||LJLJF7L7L7F----JL7L--7-|FJ7LF7|L|J\n" +
            "7JL|.LJL-7F--7LJ|F-JLJ|FJLJL-J|||||FJF-JFF7FJLJF7F--JF7L--7FJ|F----JF7FJLJLJL7FJF---JFL7LJF-------JFJL-JLJF--7|L7L-JL---7F7|F--JJFL-L7L7|.F7\n" +
            "-77J.|7|.||77L-7|L-7F7LJF7F-7FJ|||||FJF7FJ|L-7FJLJ|F7||F--J|FJL7F7F7||L----7FJL7L7F7F7JL-7L7F-7LF7-L---7F-JF7LJJL--7F---J||||F-7F7L7.JL7JFJ|\n" +
            ".---.LF|-LJF---J|F7LJL--JLJ|LJL|||||L7||L7|F7|L-7F7|LJ|L-7FJL-7||||LJ|F7F7FJ|F7L7|||||F7FJFJL7|FJ|F7F-7|L--JL7F7F-7||F7F7|LJ||FJ|L7J-L-J.L7L\n" +
            "|J|J.L7J7|-L---7LJL------------JLJLJFJ||||||LJF-J||L-7|F7|L7F-J|||L7FJ|||LJFJ||L|||||LJ|L7|F7|||FJ||L7LJF---7LJ||FJLJ|LJLJF7LJL7|FJ7-LJFL.|J\n" +
            "L7J77FL-JLFF7F7L--7F7F-7F--7F-7F---7|FJ|FJ|L-7|F7||F7|||||FJL-7LJ|FJ|FJ|L-7|FJ|FJ|||L-7L7|LJ||LJ|FJL7L-7|F-7L--J||F7FJF7F-JL---J||L7...F7F|J\n" +
            ".J7F-JF-.F-JLJL---J|LJFJL7FJ|FJ|F--J||FJ|FJF7|||||||||||||||F7|F-JL7|L7|F7||L7|L7|||F7L7||F-JL7FJL7FJF7|||FJ.F--JLJ||FJ|L7|F----JL7J7-FLF7J|\n" +
            "F||L||FJ7|F7F7F7F-7|F-JF-JL-JL7|L7F7LJL7||FJLJ||||LJ|||||||FJ||L7F7||FJ|||||FJL7|||||L7|||L-7FJL7FJL7|LJLJL--JF7F--J||7L7|FJF-7F-7L77F|7|LF|\n" +
            "F|77-J7L-LJLJ|||||||L--JF7F7|LLJ.||L7F-J||L7.FJ||L7F|||||||L7||FJ||||L7LJLJ||F-J|LJ|L7|||L-7||F7|L7FJL7F7F----JLJF--JL-7|LJFJL|L7L7L777-.FLJ\n" +
            "JJJ||FJFLLF--J|||FJ|LF7FJLJL7F7F7LJFJL7FJL7L7L7|L-JFJ||||||FJLJ|FJ|||FJF---J|L-7|F-JFJ||L7FJ|LJ||FJL7FJ||L---7F-7L7F---J|F7|F7L7|FJFJJJ7-7.|\n" +
            "L7-L-LJ7|||F-7|LJL-JFJLJF7F7LJLJ|F-JF-JL-7L-J7|L-7FJFJ|||||L7JFJL7|||L7L-7F7L-7||L7FJ7||FJ|.L-7||L77|L7|L----J|FJFJL--77LJ|LJL7LJ|FJ7|-7.|7|\n" +
            "|.|.JJ7F-7LJJLJF---7L--7|||L---7|L-7|F-7FJLF7FJF-JL-JFJ|||L7L7|F7|LJL7L7FJ|L7FJLJFJL-7||L7L--7||L7|FJFJ|F7F7F7||FJF7F7L7F-JF-7L7FLJJ-J7LL-J-\n" +
            "|FF-|FFL7L-7F-7L--7|F-7LJLJF---JL--JLJ||L-7||L7L7F7F-JFJ|L7L7|LJ|L--7L7|L-JF|L-7JL-7FJLJFJF7FJ||F||L-J7LJLJLJLJLJFJLJL-JL7FJLL7L-77JLFJ7LFJ7\n" +
            "7JL-F-7|L-7|L7|F-7|||FJ.F-7L---7F7F7-F7L-7LJL7L-J|LJF7L7L7|FJL-7L7F-JJLJJF7FJF7L7F7|L-7FJFJ|L7|L7LJJF7F7F--7F7F-7L-----7FJL--7|F-JJ7.|-77|F-\n" +
            "F77FL7L-7F|||||L7LJLJ|-FJFJJF7J||||L-JL-7L7F7L7F7L-7|L7L7||L-7FJFLJF-----JLJFJL7LJ|L--JL7L7|FJL7|F--JLJ|L-7LJLJL|F7F---J|F7F7||L7LLLLL7F-7||\n" +
            "|JLF7|F7L-JL7|L7L---7|FJFJ-FJL-J|LJF--7FJFJ|L7LJ|F-JL7L7|||F-JL---7L7F7F--7FJF-JF-JJF7F7|FJ|L7FJ|L-7F-7L--JLF7F7LJ||F-7|LJLJLJ|FJF|F|F|J|7J|\n" +
            "J-||LJ|L---7||FJF---JLJFJF-JF---JF7L-7LJ-L7|FJF-JL7F7L7|||||F7F-7FJ|LJLJF-JL7|F7L--7|LJLJL7L7|L7|F7LJF|F---7|LJL-7LJL7L------7LJ7|7-7-LJJL-J\n" +
            "|JFL--JF---JLJ|FJF7F7F7L7L-7|F---JL-7L--7FJ|L7L--7||L7|LJ||LJ|L7||FF7F--JF7FJLJ|F7FJL7F-7FJFJ|FJ||L---J|F--J|F--7|F-7|F---7F7L-77F7J.|F777.|\n" +
            "L-||LF-JF7F--7|L-JLJLJL7L-7LJL-7F7F7L---JL-JF|F7FJ|L7|L7FJ|F-JFJ|L-J|L--7||L-7FJ||L-7LJ7|L7|FJ|FJL-----JL---JL-7LJ|FJ|L-7LLJL-7|F-77--J|FFF.\n" +
            "J7FJ-L-7|LJF-JL--------JF7L7F-7LJLJL7F7F7F7F-J||L7L-J|FJL7|L-7L7|F-7|F--J|L--J|FJ|F-JF--JFJLJ7LJF7F7F------7F-7L--JL-JF7L----7|||FJ|.LF|LL77\n" +
            "FJ.7||-LJF-JF7F-7F-7F--7||FJL7|F----J|LJLJ||F7|L7L--7LJF-JL-7L7|||FJ|L--7|F-7FJ|FLJF-JF-7L--7F7FJLJLJF----7LJFJF-----7|L7F---JLJ|||F7F-|7.L|\n" +
            "LJF77||-LL7FJLJ|LJ7LJF7LJ|L--JLJF7F-7|F-7FJLJLJLL7F7|F7L-7F7L7||||L-JF--JLJFJL7L7F7L-7L7L7F-J||L----7|F---JF7L-JJF--7LJL||F---77|L7F-JJLF77J\n" +
            "|LL|FJJ-FFJ|F--------JL--JF7F-7FJ||FJ||JLJF7F7F7F|||LJ|F-J|L7|LJ|L--7L7F7F7L7JL7LJL-7L7L7||F-JL7F7F7LJL----JL---7|F-JF-7LJ|F--JFJFJ--L7FJFLJ\n" +
            "JFF||J|-L|FJL---7F7F--7F7FJLJJLJJLJL-JL---JLJLJL7|||F-JL-7|FJ|LFJF--JFJ|||L7L-7L7F7FJFJFJLJL--7LJLJL7F7F-------7LJL7FJFJF-JL-7FJFJ-|-F7|L7J|\n" +
            ".FFL7-7.FLJ7F-77LJLJF-J|||F----7F-7F7F------7F7FJ|||L--7FJ|L7L7L7|F--JFJLJFJF7|FJ||L7L7|F7F--7L----7LJ||F-----7|F7FJL7L7L7F--JL7|F-777LJ7F-7\n" +
            "FF7F|-7--.|FL7|F7F-7|F-J|||F--7|L7LJ|L--7F-7||||FJ||F7FJ|FJJ|FJFLJL-7FJF--JFJLJL7|L7L7||||L-7|FF7F7L-7|LJF----JLJLJ7|L7L-JL----J||FJLL-|7FJ.\n" +
            "F-J-L-|JF7-F7|LJ|L7|LJF-J|LJF-JL-JF7L--7LJFJLJLJL-J||||F||F-JL7F----JL7L--7|F7F-JL7|FJLJ||F7|L-J|||F-J|F7L-----7F7F7F-JF7F7F-7F7LJ||7J-|JJ.7\n" +
            "|--.|.--LFJ|LJF7L-JL7-L-7L7|L--7F-JL7F7L-7L----7F--J|LJFJ|L-7FJL-7F7F-J7F-JLJ|L7F7|||F--JLJLJF-7LJ|L-7LJL------J||||L7FJLJ|L7|||F7|J7.FJJJ.F\n" +
            "FFJF-7|7J|FJF7||F-7FJF7|L7|F7F-J|F--J||F7L-----JL--7L-7L7L7FJL-7FJ|||F7FJF7F7L7LJ||LJ|F-7F7F7|FL-7L--JF----77F7F|LJL-JL--7L7|LJLJLJJFF7...L-\n" +
            "LJ77LJJ|.-L7|LJ||FJL7||F7LJ||L-7|L-7FJLJL-7F---77F7|F7|FJFJL7F-JL-JLJ|LJFJ||L7|F-JL-7||FJ|LJLJF--JF--7|F---JFJL-JF---7F--J7LJFF---7FJJ-7|-LJ\n" +
            "..FJ.|FLF7|LJ7LLJL-7|||||F7||F7LJF7LJF----J|F--JFJ|||LJL-J|-|L77|F---JF7L7||FJ|L-7F-JLJL-JF7F7L---JF-J|L----JF7F7L--7|L7F--7F-JF-7L7.|J|J7|.\n" +
            "L-|FF-J.F77-|JL|F--JLJLJLJ|||||F7|L-7L----7|L7F7|FJ|L-----7-L-J-FJF7F7||FJLJL7|F-JL--7F7F-JLJL----7L7FJF---7FJLJL---JL-J|F-J|F7L7L7L-7-L-|L7\n" +
            "..L--7.F-JJ.JJFFJF7F-7F--7||LJLJLJF7L----7LJFJ|LJL7L------J..L..L7||||||L-7F-J|L7F7F-J|LJF-7F7F7F7L7|L7L--7|L--7F-------JL--J||FJL|F-J-|.-.J\n" +
            "J-|JL--J||.|FLFJFJ||FJ|F-JLJF7F7F7||F---7L--JFJF--JLF----7-F7LL-L||LJ||L7FJL7FJFJ|||F-JF-J-LJ||LJL7|L-JF7FJL---J|F----7F7F7F-J|L77LJJ7FLF|7|\n" +
            "JLLJ||7J|J7--FJFJ7LJL7|L7F-7|||LJLJLJF--JF7F7|FJF7F7|F---JL|LJLLLLJF-JL7|L7FJL7L7|||L7FJF----J|F--JL---J|L----7L|L---7|||||L-7L-J--L|-|F-7.-\n" +
            "J.|F|LL7LJJ.FL-JF---7LJL||FJ|LJ|F---7L-7FJLJLJL-JLJ|||F-7-|JF.-7LLJL-7FJL-JL-7L7LJ||7LJ7L----7|L7F7F---7L---7FJFJF-7FJ||LJL7FJFF7JFLJFJ|....\n" +
            "FF-7J.LJJJ.F-FF7L--7L---J|L7|F--JF-7L--J|F--------7LJLJFJF-7L|||LJ7|F|L-7J|LFL-JLFJ|F----7F7FJL7LJ||F-7L---7|L-JFJFJ||LJF7|||F7|L7J.FLLLJ-77\n" +
            "J-.7.L.||.LF7FJ|LF-JF----JFLJL-7FJFJF---JL-------7|F7F7|J|FJ7|LJJ|||FL7FJ7L-JJJ7FL-JL7F-7LJLJF-J-FJ|L7L----J|F7FJ|L7L--7|L7|LJLJFJ-LJ.||||FL\n" +
            "|-LJF|77|7L-LL7L-JF7|F---7-F7F7LJFL-JF-7F7F------JLJ||LJFJL7-J-JFF-J--|L-7JLLJL-7JL7L||FJF---JF7FJFJ|L7F--7FJ||L--7|F-7LJFJL7F-7||||7|-LF7L|\n" +
            "|-L7FJFFJ7|7|FL-7FJLJL7F7L-JLJL--7F-7L7|||L----7F--7LJF-JF-JL|.L7J.|7-L--J.7J.|LJJ.J|LJL7|F---J|L7|-F7LJF-JL7||F--JLJLL--JF7|L7LJ-LLJJ|FF7FJ\n" +
            "-JLL--|J.F7F-F7FJL-7F-J|L-------7|L7|FJLJL7F-7FJ|F-JF7L7FJF-7-JLL7F||||J|F7LF|F7J.FF|FF7LJL---7L-J|FJL7JL7F7LJ||F7F7F7LF7L||L-JJLJ.FL7FJLLF7\n" +
            "|F|.JF|-7F-7||||F--JL--JF7F-----JL-JLJF7LFJL7LJFJL-7||FJL-JFJ.LJFJ77|FFFL7.77|LJFJFLF-JL-----7L---JL-7|F7||L-7|LJLJLJL-JL-JL--7J|FL-JL.L-JLJ\n" +
            "L-J7.LLJFL7|FJ|LJF-77F7FJLJF---7F7F---JL7|F7L--JF-7LJLJF---JJFLF|7LJ-L77J-F|J|F-|FF|L-7F--7F7L-------JLJLJ|F-JL-----7F-7F7F---JF7-L.F.FLL7..\n" +
            "|J|L7LL-JFJ|L7|F7L7|FJLJF-7|F7|LJLJF----JLJ|F7F7L7L7F-7L-7F7-||L-LJ.|LJL.--L7.7.LJ-FF7LJF7LJL-------------JL-----7F7LJ-|||L----J|.LF7-|-|FJ7\n" +
            "L-L-7-||FL7L-J|||FJLJF-7||LJ||F7.F7L-----7FLJLJ|FJFJL7L-7LJL-77JLLJ.L|7.7||F77FJJLJFJL--JL------7FF7F7F------7F-7LJL7F7LJL------J77JL-|.7L|7\n" +
            "7-|7|FFF7FJF-7|||L7F7L7LJF--J|||FJ|F7F-7FJF7F7-|L7L--JF7L-7F7|JF-LF7FF7-JFFL-J7J.JF|F----7F7F7F7L-JLJ|L-----7LJFJF-7LJL--7F-----7.L.7||7JF-7\n" +
            "|LL.FF-|LJFJFJLJL-J|L-JF7L--7|||L7LJLJFJL-JLJL7L7|F7F-JL-7||LJ-F7FJ|F||-.|7.7J|LFFFLJF7F7LJLJ||L7F--7|F-----JF7L-JJL7F--7||F----J7.FL7F--J7|\n" +
            "F7..|J.L7FJJL--7F-7L-7FJL---JLJL-JF7F7|F7F----J-LJ|LJF--7|LJJJ.LFL7|7-7.L7J-|7|-J-|LFJ|||F7F7LJ7LJF-JLJF-7F--JL-7F-7|L-7LJ|L-----777.FJ7FJ-F\n" +
            "LJ77.LFFJ|7.|F-JL7L7FJL----7F-----JLJ||||L--------JF7|F7LJ-JJ7FF7FJ|J|L7F|J7|FJ-|F|-L7LJLJLJ|.F---JF7F7L7LJF----J|FJL--JF-JF7F---JF7F7-JJ7F|\n" +
            "FL77F-FL-J7L7L---JLLJF-----J|F7F-----JLJ|F7F7F-7F-7|LJ|L-7.|L|||LJFJ77L--LF7-FJ||-|F-JF--7F7L7L----J|||FJF7L-----JL-7F--JF-JLJJF7FJLJ|.L-J-F\n" +
            "FFLJJ7J||--.F-7F7F7F7L------J|LJF------7LJLJ|L7LJF|L--JF-JF7|LFL-7|J|7..|L-J-----7FL--JF7||L7L7JF---J|||FJL7F-------J|F--JF7F7-|LJF7FJ7F|FFJ\n" +
            "LJ-J-FJ|L7JFL7|||||||-F---7F-JF-JF--7F7L---7|FJF-7|F---J7FJ|7-F7FJL-77-7|FJ|-|F-JFJLF7-||LJ|L7|FJF7F7|LJL-7|L-7LF7F--JL--7|LJL7|F7|LJ|F7FF77\n" +
            "L-FJL7FJ-F7F7|LJLJ||L7L--7LJF7|F-JF7LJ|F---J|L-JFJ|L----7L7L--JLJF--JJ|F-7.F.F7J7F--JL7||F7F7|||FJLJ||F---JL--JFJLJF7F7F7LJF7FJ||LJ.F7||7JL7\n" +
            "|FJ7.|J|.|||||F--7||FJ-F7L--JLJL-7|L77LJF-7|L7F-JLL-----JLL--7F7FJF77.FJFJ.F7|L77L---7LJLJLJLJ||||F7LJL----7F-7L7F-JLJ|||F-JLJF|L-7-|LJL7FL7\n" +
            "-|JL7J|-FJLJ|LJF7|LJL--JL----7F7.LJFJF77|FJF7LJF7LF7LF7FFFF-7LJ|L-JL7-L7|FS|||FJF7F7LL-------7|LJFJL77F----J|FJFJL--7JLJ|L--7F7|F-JFJF-7|-|J\n" +
            "FF7FFJ..|F-7L--JLJF---------7LJL---JF|L-JL-JL--JL7|L7|L-7FJFJF-JF---J|FJ|||||||-||||F7F----7FJL7JL-7L7L-----JL7|F---JF-7L7F7||LJL--JFJJLJJ||\n" +
            "|LLLF---LJ|L-7F--7L7F-7F--7FJF7F-----JF-7F-7F---7||FJL-7LJFJFL-7L-7F7-L7LJ||LJL7||||||L---7|L7FJF7.L7|F-7F--7FJ|L----JFJJ|||LJF7F7F-JLJJFFLJ\n" +
            "7|LLF77JLF---J|F-JFJL7|L-7LJFJLJFF----JFJL7||F-7LJ|L7F7L-7|F7-FJF-J||JFJF-JL-7FJ|LJ|||F7F-JL-JL7|L7FJ|L7|L-7LJL|F---7FJF7LJL7FJLJ|L7J7..7|..\n" +
            "|7FL7J7LFL----JL-7|F-J|F7L--JF7F-JF--7.L--J|LJFJ-FJFJ||FFJLJL7L7L--JL7L7L--7FJL7L-7||LJLJF7F--7||FJL7L-JL--J-F7|L-7FJL-JL-7L|L--7|FJ|JF.7J77\n" +
            "LL|-JJ|7F.F7F--7FJ|L-7LJL-7F-J|L--JF7L7.F-7L--JF7L7L-JL7L-7F-JFJF----JFJF--JL7FJF7||L-7F-JLJF-JLJ|F7L7F7F7F--JLJF7||F7F---JFJF7FJ|L-7.--|J.F\n" +
            "|7|LL-.F--J|L-7|L-JF7L--7FJL-7|F7F7|L-JFJFJ|F7L||FJF7F-JF-JL-7L7L--7F7|FJF-7FJL7|LJ|F7LJF---JF7F7LJL-J|||LJF--7FJLJ|||L-7F7|FJ||FJF-J.JFF-J7\n" +
            "77J|L|7L7F7L7FJL7LFJL---JL-7FJ||LJ|L---JFJF7|L7|LJFJLJF7|F-7FJFJF--J||||FJFJ|F7|L-7||L7|L---7|||L7F--7|LJF7L7FJL--7|||F7LJ|||L||L7|JLFF7LFJF\n" +
            "||FJ7LJLLJL7|L-7L-JF-7F---7|L7|L-7L---7FJ7|||FJL-7L7F7||LJFJL7|FJF77|LJLJFJLLJ|L--J||FJF7F-7LJLJ|LJF7LJ-FJL-JL----JLJLJ|F-JLJ|LJ-LJ.7.LJ..F|\n" +
            "7-7JF-7.FF7|L--JF7FJJ||F--J|L||F7L---7|L--JLJL--7L7LJ|||F7L-7|||FJL7|F--7|-F-7L---7LJ|FJ|L7|7F7F7JFJL--7L---77F--7F---7LJF7F7F7-|J|F|7|FFL7J\n" +
            "L.7LJJFF-JLJF7F-J|L-7LJL7F7L-JLJL----JL-7F-7F---JJL7FJ||||F-JLJ||F-JLJF7|L7L7|F7F7L-7LJFJFJL7|LJL-JF7F7L----JFJF7||F--JF-JLJLJ|J|-JJ.LL-|.|.\n" +
            "LJJF-7FL--7FJ|L7FJF7|F--J|L7F-7F7F-----7LJ.|L7F-7F7|L7||||L7F-7||L--7FJ||FJFJ||LJL-7|F7L-JF-J|F7F-7|LJL7F7F7FJFJ|LJL7F7|F---7FJ--7F|7||L--|7\n" +
            "||FF777F7|LJJL7|L-JLJL--7|FJ|FJ|LJF-7F7L7F7|FJL7||||FJ|||L7LJJ|||F--J|FJ||JL7|L7F-7|LJL7F-JF7LJLJ-LJF7.LJLJLJFJ-|F-7LJ||L-7LLJJFF|7.7-F7J.|F\n" +
            "F-FJL--J|F7J-LLJ|F------J|L7||FJF7L7LJL-J||LJF7|||LJL-J||FJLF7|LJL7F7|L7|L--J|FLJ7||F--JL--JL7F-7F--JL7F7F--7L-7LJL|F7LJF-JF-7-LLFL7JLJJ-F7J\n" +
            "-7L7F--7LJ|F7F7F7L-------JFLJLJFJL7L----7|L-7|||LJF----J|L-7||L-7FJ|||FJL---7L-7F-J|L---7F---JL7||F7F7|||L-7L-7L7F7|||F7L--JFJ7..|.F-7LLJ|||\n" +
            "L-7LJ77L-7|||||||FF7F7LF77F7-F7L-7L-----J|F-J||L7FJF7F7FJF-J|L7FJL-J||L-7JF7L7FJL7FJF7FFJL7-F--J|LJLJ||||F7L-7|FJ|||||||F---JJ.7-7FJF-7.7-F7\n" +
            "7F-LF-7F7|||||||L7|LJL-J|FJL-J|F7L---7F7FJ|F7|L-J|FJLJ|L7|F7L7|L7F--JL-7L7|L7||F-J|.||FJF7L7L--7L7F--JLJLJL--JLJF||LJLJ|L-----77F|7F|LL7|.|J\n" +
            "||J.L7LJLJ|||||L7||F---7|L-7F7LJL---7|||L7||LJF--JL-7FJFJ||L7||FJL-7.F7|FJL7|||L7FJFJ|L7|L-JF--JFJ|F7F-7F77F--7F7|L---7|F7F---JL7||J.-L|F7JF\n" +
            "F|7--L---7||||L7||LJ-F-JL-7LJL-----7LJ|L7||L-7L--7F-JL7|FJL7LJ|L7F7L7|||L-7||||FJL7L7|FJL-7FL--7L7LJLJLLJL-JF7LJLJF7F-JLJLJF--77|L|7||.|LJ7F\n" +
            "L|JLF7FF7|||LJFJ|L--7L---7|.F--7F7FJF-JFJ|L--JF--JL7F7||L7F|F7|7||L-J|||F-J|||LJF-JFJ|L7F-JF7F-JFJF--7F7F---JL----J||F7F7F7|F-JF7FLF-F-7JFJ|\n" +
            "L7.FJ|FJLJLJF7L7L-7FJF7F7|L-JF7LJ|L7L-7L7L--7FJF7F7||LJ|FJFJ|LJFJL7F7||||F7|||F-JF7L7|-||F7||L-7L7L-7LJ|L---------7LJ|LJLJLJL--JL-7-.LJ|-FJ7\n" +
            ".7-L7LJF--7FJL7|F-JL-JLJLJF--J|F7|-L-7|FJF--J|FJ|||||F7|L7L7L7FJF-J|||LJ||LJ||L-7||FJL7|||LJ|F7L7L7FL7FJF--------7L--JF7F---------JJ7F||.|LJ\n" +
            "F-77L-7L-7LJF-J|L--------7|F-7LJ|L---J|||L-7FJL7||||||||FJL|FJL7|F7||L-7|L-7||F-J||L7FJ|||F-J||F|FJF7|||L-----7F7L7F7FJ|L---7-LL|J.LL7FLFFJ.\n" +
            "L7L---JF-JF7L-7L---------J|L7L--JF-7F-J|F-7|L-7|LJ||LJ||L7FJL7FJ||||L7FJ|F7|||L7FJ|FJL7|||L7FJL7||FJ||L7F-----J|L7|||L7L7F7FJ.L7|J7.|-|7||7|\n" +
            "LL-7F7FJF-J|F-JF---------7|FJF7F-JFJ|F-J|||L7FJ|.FJL7|||FLJF7LJJ|||L7LJ7LJ||||7||FJL7FJ||L7|||FJ|||FJ|FJL-7F7JFJFJLJL-J|LJLJ|7.FJ7|7.FJ|JL||\n" +
            "L|FLJ||JL-7LJF-JF--------J||FJLJF7L7||F7L7|FJL7|FJF7L7|L---J|F--J|L7L-7F--J||L7|||F7|L7|L7||L7|FJ||L-JL7F7LJL-JFJJF---7F---7F7F7F-7L||FJ|7L7\n" +
            "FLJFFJ|F7FJF7|F7|F7F7F-7F7|||F--JL-J|||L7|LJ.LLJL7|L-J|F7F--JL-7FJFJF7|L7F7|L7|LJ||||J||L|||FJLJ7||F---J||F-7F7|F-JF7FJ|F--J|LJLJFJ.FL7FLLL-\n" +
            ".LF-L-J|LJFJ|||LJ||||L7||||||L--7F-7||L7|L-77FF--JL7F-J||L--7F-JL7L7|LJFJ|||FJL7J||||FJL7LJ|L-7F7LJL-7F7||L7||LJ|F-J|L-JL-7FJF--7|..|.LL-J.J\n" +
            "FLJF|.FJF7|FJ||F7|LJ|FJLJLJ|||F-J|.|||FJ|F7L7FJF-7FJ|F-J|F7FJ|F-7L7|L-7L7|||L7FJFJ|LJ|F7L-7|F7LJL7F--J||||FJ|L--JL-7L--7F7LJFJF7LJ77L7.|---.\n" +
            "F.L77-L7|||L7|LJ||F-JL-7F--J|FJF7L7LJ||-|||FJL7|FJL7|L7L|||L7||FJFJL7FJ|LJ|L7||7L7L-7|||F7|LJL7F-JL7F-JLJ||FJF7F7F-JJF7LJL-7L-JL77.77---.LL7\n" +
            "L||L|7FJ|LJFJL-7LJ|F7F7||F7FJL7||FJ|FJL7||LJF7||L7FJL7L7LJ|FJ|||FJ7||L7F7FJFJ|L-7L7FJ|||||L7F-JL7F-JL---7|||FJLJ|L7FFJL--7FJF7F7L-7F7-77FJ-L\n" +
            ".L||L-L7|7-L7F-JF-J|||||||||F-J|||F-JF7||L7FJLJ|FJL-7L7L-7|L7|||L-7FJFJ||L7L7|F-JJLJJ|||||FJL-7FJ|F7F---JLJ|L-7-L7L-JF-7FJ|FJ|||F-JJLF|F7.-|\n" +
            "|LF-J.FLJ7F7|L-7L--JLJLJLJLJL-7|||L-7|||L7|L7F7|L7F-J7|F-J|FJLJ|F-J|FJFJL-JFJ||F7|F--J||||L7F-JL7LJ|L--7F--JF7L7FJF7FJFJL7LJJLJ|L7J|-7|LF-J|\n" +
            "7..FJ-FJF7|LJF-JF---7F7FF7F---J|||F7|||L7||FJ|||FJL--7|L7FJ|F7F|L-7||FL7F-7|FJLJL7L7F7||||FJL7F7|F7L-7FJL--7|L-J|FJ|L7|F7L-77.LL-J|LJL|.JJF|\n" +
            "|L7||7F-JLJF-JJ.L7F7LJL-JLJF7F7|LJ|LJ||FJ||L7|LJL7F7FJ|FJL7LJ|FJF7|||F-JL7|||F7F7|FJ||||||L7FJ|LJ||F-JL--7FJL--7|L7|FJLJ|F7|-J77|L|J-FJ7LFF7\n" +
            "||F-J-L--7FJJF--7LJ|F7F-7F7|||||F-JF7||L7|L7|L7F-J||L7|L77|F7||FJLJLJL7F-JLJ|||||||FJ||LJL-J|FJFFJLJF7F-7|L7F--J|FJ|L-7.||LJ..L-|-|JF7J--FF|\n" +
            "LJ-.|7LLL||7.L-7L--J|||FLJ||||||L7FJ|||FJ|FJL-JL-7||FJL7L7||LJ|L--7F--JL--7FJ|||||||FJL7F--7|L-7L--7||L7||FJL-7FLJJL-7|FJL7F-7||LFF-J..||FJL\n" +
            "..L7---FFLJJ-.LL-7F7||L7F-J|||||FJ|FJ|LJFJL---7F-J||L7FJFJ|L-7L7F-J|F-7F-7|L7|||||LJL7FJL-7LJF7|F--J||FJLJL7F7L-7F-7FJ|L7FJJLJF|7-FL---|-L77\n" +
            "F|.|7JFF7J||.LJFFJ||||FJ|F7|LJ||L7||FJF-JF----JL-7|L-JL-J7|F-JFJL-7||FJL7LJFJ||||L7F-JL-7J|F7|LJL--7||L-7LFLJ|F-J|FJL7|JLJ|L7.|||7.|.|F.|FLJ\n" +
            "--L7J.FL7.L--JL-L7|||||FJ||L7-||L||||FJF7L---7F--JL--7F---JL-7L7F-J||L7FJF-JFJLJL-J|F7F7L7LJLJF7F-7LJ|F7L7F--JL-7|L-7LJ.|J|-L7.FJ|7J7L|7FL7J\n" +
            "F-7LJ-J-LJ||L-|7L|||||||FJL7|FJL7||||L7|L7F7FJL7F7F7FJ|F7F7F7L7|L-7LJ7|L7|F7L-----7LJ||L7L-7F-JLJFJF-J|L-J|F-7F7LJF-J.FF|-J.FJF|.L7L7||-|-|7\n" +
            "L|-JJ.LJ7FL|.LL7LLJLJLJLJLFLJL--J|||L7||FJ|LJ7FJ||||L7|||||||FJ|F7L7F-JFJLJL7F7F7FJF-J|.|F-JL-7F7L-JF7L--7LJ-|||F7L-7-|J|7.JJ.-L7FJ7|LJ-J|L-\n" +
            "|||JFF.|FL-77|L--JJ.|F|LLLF-F----J|L7|LJL7L--7L7|||L-JLJ||LJ||FJ|L7|L-7|JLF7|||||L7L-7|FJL---7|||F7FJ|F-7L7LFJ|||L--JL|.7F--FFL|-J.LJJ.J-|JJ\n" +
            "L-|-L.FFLJ7LJ7.|7L7L-JJ7|LLFJF-7F7L7||JF7|F7FJ.LJ|L-7.F-JL-7LJL7|7||F-JL7FJLJ|LJL7L7FJ|L7F7F7|||||LJFJL7L-JFJFJ|L---7FFF|7JF77-L.|7LF|-77|.F\n" +
            ".L..J7|L7L7-|7-FLL|JLJ-7F-.|FJLLJL-J||FJLJ||L7F--JF-JF|F7F7|F7LLJ-LJL-7FJL--7L--7|FJL7|JLJ||LJLJLJLFJF7L-7JL7|7L7F7FJJ-JLL7||J.|.-F-|J|-J--7\n" +
            "77.|LFF.FFF.--777||-J-JL7JF||JLLJ7|-||L7F7|L7|L7F7L--7LJ|||LJL7J|-LF--JL7F--JF-7|LJ7F|L7-FJ|F------JFJ|F7L7FJL-7LJLJ7|L7J|FL|7F|.|J||LL7|.F7\n" +
            "|7-|F7J.F7.FJLFLJJ|7FFJJ.|.LJ.|JF-L7LJFJ|LJ|LJFJ||F-7L7.LJL---JLL-JL7F-7|L--7L7LJJFJF|FJFJFJL-7F-7F7||LJ|FJL7F7L--7JJ7J|-7J||-FF777LJ7L|77||\n" +
            "|J7LJLFFF|7JFLF7-LJ7FL7.|LFJJ7F-7..JJFJFJ-F-7F|FJ||7L-J-J-L7FJJ-F-7FLJ||L-7FJFJF7J|LL||-L7L7F-J|FJ||L-7L|L7FJ||F--JJF-F.L7F7-F-L-77---7LFFLJ\n" +
            "|.|JJFJL-J|LF7||7J|J|L|-|77J.LFLJ-JJ7L-J.|LJJFLJ.LJ7-|JFJ.LF|JJ-J7|L||FL7FJL7L-JL7JJLLJ.F|FJ|F7|L7||F7L7|FJL7|LJFJJFF..L7|-F-FLL7L7JLLL-J|L-\n" +
            "|7JLF7L7J7|LFL7.LFL-7JL|LJ-.--7.|7L77L7|.7L|7LJ7F|||.JJJ|7F777F-J.F-LL7FLJF-JF-7FJ7---|F-LJL||LJ|||LJ|FJ||LFJL--77|LJF7|LJ.LF7JLFLJF-F|-LF-J\n" +
            "L7.L-JL|.L7J|L77JL--7.FJ-|.F|-||777.LF|-L77L|FLL7FJ77J.FL7-|-FJ---F-7-J7JL|F7||LJ.|J.FJFL.LFLJF--JL-7LJLLJL|F-7FJ77.FF.J7.F.FFJFL.|LF||J-JJJ\n" +
            "LFF7.L-JJ||F7-L-7.|7F-LJ-|-JF-7-77FF7F|.JLFJLJJLF-.LL-|7LF7|-J77FJ.LL7J|FL||LJ7J-F-F777|7-F|7.L---7FJLJ.LF-JL7|L7-J-JJ7-FFL-F7-L7-|F7JFF7L-7\n" +
            "F|L7-.LJ||L|J-|LF7FJ7JF|FJJ7||L|LL|J|--F7.|7|L7LL|7.FFJ77LL.7FJJJ.F7J|---LLJLLFJL|F|.FL7|.J.LJLFF-JL-7-JJL7F7|L-J77F.L77LJL--J||L.L7|L777.L-\n" +
            "LJ7JL7LFF.FJ-F-.LJF|LLFF|7-F7L-J7|.FL7LJ--F-|-J..||FF7-JJ7|-|JJFF7|JFL77FLLJ.JJ7-77.L-7FL-J7||-LL7F--JJ.||LJLJJ.||FL7|L|.JJLL-J7|7LFJ|.-|77|\n" +
            "LJ||.77FF--JL7JL|FL|.L-|JL-J7.JLF-7.|7||7F7|.F-J-F-J|L7-LF|7F7.FJFJFJ-L77.|F-7LJ7F7|FL7JFF7F7F-|7LJJ.|7F|7FJF|F--77..F-L7--7FL7-|J--J-L-|.|-\n" +
            "L-7-7|F7J7J7FL7.L|.|7-7L7LLJJ7||L|JFJLLJL7L-7|L7--.FF-77|L--L-7JJL-JJ7LJLLJFL|LFJ.LJF-7F|L||LL7-|-L-J|-|.F--F.|JFF|-.-J--7-|7FLLJ-F|-FJF77|J\n" +
            "--|.L7FL7|--L7LF||F7LFF7..F||LL7-F..F.L-.F7|FF7JFL7|||JLFJ.FLFJJ7FJJ7-FJF-|L7|-J.L|7|FF-|JL7.JJ.LF7J-7-F7JF-77L-.||.FJF7-J--77LLF7FL7|JF-|.|\n" +
            "J.|.LFJ--L-..L-LL|-LF-.|.J.LJLLF.-.FJ|-L|--7JL|-F--|77.L777-7.L-JJLLJ.J-7L-J|-JLF-LLJ-7.7-LJ-JJF-J7.7JJJL-FLLJ-.FFJ..LLF-J-|7JJ.LFF7L|L-JL|-";
}

