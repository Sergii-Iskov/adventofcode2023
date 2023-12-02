package com.shpp.p2p.cs.siskov.adventofcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This task "Day 1: Trebuchet?!" is from https://adventofcode.com/2023/day/1
 * We need to calculate the sum of all of the calibration values of document.
 */
public class day1 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> calibrationDocument = new ArrayList<>();
        fillCalibrationDocument(args[0], calibrationDocument);
        int result = calculateCalibrationValues(calibrationDocument);
        System.out.println(result);
    }

    /**
     * Transform document on the ArrayList of strings
     *
     * @param param A start document with lines of text.
     * @param calibrationDocument ArrayList with lines of text.
     */
    private static void fillCalibrationDocument(String param, ArrayList<String> calibrationDocument) {
        String fileName;
        try {
            fileName = param;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            // Use the standard file-reading loop to construct the name list
            while (true) {
                String line = br.readLine();
                if (line == null)
                    break;
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
            String resultSting = "";
            for (int i = 0; i < line.length(); i++) {
                if (Character.isDigit(line.charAt(i))) {
                    resultSting += line.charAt(i);
                    break;
                }
            }
            for (int i = line.length() - 1; i >= 0; i--) {
                if (Character.isDigit(line.charAt(i))) {
                    resultSting += line.charAt(i);
                    break;
                }
            }
            System.out.println(line + " = " + resultSting);
            // if string npt consist digits, its calibration value equals 0
            if (resultSting.length() != 0) {
                result += Integer.parseInt(resultSting);
            }
        }
        return result;
    }
}

