package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01Part02 {

    public static void printCalibrationSum() {
        int calibrationValueSum = 0;
        try {
            Scanner scanner = new Scanner(new File("src/day01/inputDay01_b.txt"));
            while (scanner.hasNextLine()) {
                calibrationValueSum += getCalibrationValue(scanner.nextLine());

            }
        } catch (FileNotFoundException exception) {
            System.out.println("Datei nicht vorhanden");
        }
        System.out.println(calibrationValueSum);
    }
/*
* Character.isDigit(calibrationString.charAt(index))*/
    private static int getCalibrationValue(String calibrationString) {
        String calibrationValueAsString = "";
        if (calibrationString.length() <= 2) {
            return 0;
        } else if (calibrationString.length() == 3 || calibrationString.length() == 4 || calibrationString.length() == 5) {
            calibrationValueAsString += getStringValue(calibrationString);
        }

        else {
            calibrationValueAsString += checkSubString(calibrationString);
        }


        return Integer.parseInt(calibrationValueAsString);
    }


    private static String checkSubString(String calibrationString) {
        String subString = "";
        if (Character.isDigit(calibrationString.charAt(0))) {
            subString = Character.toString(calibrationString.charAt(0));
        } else {
            for (int i = 0; i <= calibrationString.length() - 5; i++) {
                for (int border = 2; border <= 5; border++) {
                    String value = getStringValue(calibrationString.substring(i, i + border));
                    if (!value.equals("")) {
                        subString = value;
                        i = calibrationString.length();
                        border = 6;
                    }
                }
            }
        }

        if (Character.isDigit(calibrationString.charAt(calibrationString.length()-1))) {
            subString += Character.toString(calibrationString.charAt(calibrationString.length()-1));
        } else {
            for (int i = calibrationString.length() - 1; i >= 5; i--) {
                for (int border = 2; border <= 5; border++) {
                    String value = getStringValue(calibrationString.substring(i-border, i+1));
                    if (!value.equals("")) {
                        subString += value;
                        i = 0;
                        border = 6;
                    }
                }
            }
        }

        return subString;
    }

    private static String getStringValue(String value) {
        switch (value) {
            case "one":
                return "1";
            case "two":
                return "2";
            case "three":
                return "3";
            case "four":
                return "4";
            case "five":
                return "5";
            case "six":
                return "6";
            case "seven":
                return "7";
            case "eight":
                return "8";
            case "nine":
                return "9";
        }
        return "";
    }

    private static String reverseMyString(String myString) {
        String reversedString = "";
        for (int index = 0; index < myString.length(); index++) {
            reversedString = myString.charAt(index) + reversedString;
        }
        return reversedString;
    }

    public static void main(String[] args) {
        printCalibrationSum();
    }

}
