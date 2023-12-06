package day01;//Trebuchet?


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day01Part01 {

    private static void printCalibrationSum() {
        int calibrationValueSum = 0;
        try {
            Scanner scanner = new Scanner(new File("src/day01/inputDay01.txt"));
            while (scanner.hasNextLine()) {
                calibrationValueSum += getCalibrationValue(scanner.nextLine());
            }
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }

        System.out.println(calibrationValueSum);
    }

    private static int getCalibrationValue(String calibrationString) {
        String calibrationValueAsString = "";

        calibrationValueAsString += getFirstNumberString(calibrationString);
        calibrationValueAsString += getFirstNumberString(reverseMyString(calibrationString));

        return Integer.parseInt(calibrationValueAsString);
    }

    private static String reverseMyString(String myString) {
        String reversedString = "";
        for (int index = 0; index < myString.length(); index++) {
            reversedString = myString.charAt(index) + reversedString;
        }
        return reversedString;
    }

    private static String getFirstNumberString(String calibrationString) {
        for (int index = 0; index < calibrationString.length(); index++) {
            if (Character.isDigit(calibrationString.charAt(index))) {
                return Character.toString(calibrationString.charAt(index));
            }
        }
        return "";
    }

    public static void main(String[] args) {
        printCalibrationSum();
        //55130
    }

}
