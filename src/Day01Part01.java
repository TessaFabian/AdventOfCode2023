//Trebuchet?

import java.util.Arrays;
import java.util.List;

public class Day01Part01 {

    private static void printCalibrationSum(String[] calibrationStrings) {
        int calibrationValueSum = 0;
        for (String calibrationString: calibrationStrings) {
            calibrationValueSum += getCalibrationValue(calibrationString);

        }
        System.out.println(calibrationValueSum);
    }

    private static int getCalibrationValue(String calibrationString) {
        String calibrationValueAsString = "";

        for (int index = 0; index < calibrationString.length(); index++) {
            if (Character.isDigit(calibrationString.charAt(index))) {
                calibrationValueAsString += Character.toString(calibrationString.charAt(index));
                index = calibrationString.length();
            }

        }

        calibrationString = reverseMyString(calibrationString);
        for (int index = 0; index < calibrationString.length(); index++) {
            if (Character.isDigit(calibrationString.charAt(index))) {
                calibrationValueAsString += Character.toString(calibrationString.charAt(index));
                index = calibrationString.length();
            }

        }
        System.out.println(calibrationValueAsString);
        return Integer.parseInt(calibrationValueAsString);
    }

    private static String reverseMyString(String myString) {
        String reversedString = "";
        for (int index = 0; index < myString.length(); index++) {
            reversedString = myString.charAt(index) + reversedString;
        }
        return reversedString;
    }

    public static void main(String[] args) {
        printCalibrationSum(new String[]{"1abc2","pqr3stu8vwx","a1b2c3d4e5f","treb7uchet"});
        //142
    }

}
