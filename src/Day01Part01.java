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
        printCalibrationSum(new String[]{"1abc2","pqr3stu8vwx","a1b2c3d4e5f","treb7uchet"});
        //142
    }

}
