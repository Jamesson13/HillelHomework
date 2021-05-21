package lesson16.utils;

import java.util.Scanner;

/**
 * Class ScannerController
 *
 * Contains methods to check correct input from Scanner.
 */
public class ScannerController {
    public static int scanCorrectIntValue(Scanner s, int minVal, int maxVal, String preInputMsg) {
        int tmp;
        do {
            System.out.print(preInputMsg + "(" + minVal + "-" + maxVal + "):");
            if(s.hasNextInt()) {
                tmp = s.nextInt();
                if(tmp >= minVal && tmp <= maxVal) { // leave infinite loop if correct value
                    break;
                }
            } else { // bad input
                s.next();
            }
            System.out.println("Bad input! Try again!");
        }
        while(true);
        return tmp;
    }
}
