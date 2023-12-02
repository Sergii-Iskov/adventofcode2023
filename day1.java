package com.shpp.p2p.cs.siskov.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * This task "Day 1: Trebuchet?!" is from https://adventofcode.com/2023/day/1
 * We need to calculate the sum of all of the calibration values of document.
 * Created by Sergii Iskov, 2023/ Version 1.0
 */
public class day1 {
    static HashMap<String, String> digs = new HashMap<>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> calibrationDocument = new ArrayList<>();
        if (digs.size() == 0) fillHashMap();

        fillCalibrationDocument(args[0], calibrationDocument);
        int result = calculateCalibrationValues(calibrationDocument);
        System.out.println(result);
    }

    /**
     * Transform document on the ArrayList of strings
     *
     * @param param               A start document with lines of text.
     * @param calibrationDocument ArrayList with lines of text.
     */
    private static void fillCalibrationDocument(String param, ArrayList<String> calibrationDocument) {
        String fileName;
        try {
            fileName = param;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                calibrationDocument.add(line);
            }
            br.close();
        } catch (Exception exc) {
            // if the file does not exist
            System.err.println("You forgot write filename or write it with mistakes. ");
            System.exit(-1);
        }
    }

    /**
     * Calculate calibration values of every line (string) of ArrayList and sum them
     *
     * @param calibrationDocument ArrayList with lines of text.
     * @return sum of all of the calibration values of document.
     */
    private static int calculateCalibrationValues(ArrayList<String> calibrationDocument) {
        int result = 0;

        for (String line : calibrationDocument) {
            int indexFirst = -1;
            int indexLast = -1;
            String firstDigit = "";
            String lastDigit = "";
            String resultSting = "";

            for (String dig : digs.keySet()) {
                if (line.contains(dig)) {
                    if (indexFirst == -1 || line.indexOf(dig) < indexFirst) {
                        indexFirst = line.indexOf(dig);
                        firstDigit = "" + digs.get(dig);
                    }
                    if (indexLast == -1 || line.lastIndexOf(dig) > indexLast) {
                        indexLast = line.lastIndexOf(dig);
                        lastDigit = "" + digs.get(dig);
                    }
                }
            }

            resultSting += firstDigit + lastDigit;
            System.out.println(line + " = " + resultSting);
            // if string not consist digits, its calibration value equals 0
            if (resultSting.length() != 0) {
                result += Integer.parseInt(resultSting);
            }
        }
        return result;
    }

    private static void fillHashMap() {
        digs.put("0", "0");
        digs.put("1", "1");
        digs.put("2", "2");
        digs.put("3", "3");
        digs.put("4", "4");
        digs.put("5", "5");
        digs.put("6", "6");
        digs.put("7", "7");
        digs.put("8", "8");
        digs.put("9", "9");
        digs.put("one", "1");
        digs.put("two", "2");
        digs.put("three", "3");
        digs.put("four", "4");
        digs.put("five", "5");
        digs.put("six", "6");
        digs.put("seven", "7");
        digs.put("eight", "8");
        digs.put("nine", "9");
    }
}


