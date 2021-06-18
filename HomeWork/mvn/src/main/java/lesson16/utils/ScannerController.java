package lesson16.utils;

import org.slf4j.Logger;

import java.util.Scanner;

/**
 * Class ScannerController
 *
 * Contains methods to check correct input from Scanner.
 */
public class ScannerController {
    private final static Scanner sc = new Scanner(System.in);
    private static Logger resLogger;
    private static boolean logged = false;

    public static int scanCorrectIntValue(int minVal, int maxVal, String preInputMsg) {
        int tmp;
        String input;
        do {
            System.out.print(preInputMsg + "(" + minVal + "-" + maxVal + "):");
            if(sc.hasNextInt()) {
                tmp = sc.nextInt();
                if(tmp >= minVal && tmp <= maxVal) { // leave infinite loop if correct value
                    break;
                }
                input = String.valueOf(tmp); // save value of incorrect input
            } else { // bad input
                input = sc.next();
            }
            System.out.println("Bad input! Try again!");
            if(logged) {
                resLogger.warn("Bad input! (Input: {}, Correct: {}...{})", input, minVal, maxVal);
            }
        }
        while(true);
        return tmp;
    }

    public static void setLogger(Logger logger) {
        resLogger = logger;
        logged = true;
    }

    public static void removeLogger() {
        logged = false;
    }
}
