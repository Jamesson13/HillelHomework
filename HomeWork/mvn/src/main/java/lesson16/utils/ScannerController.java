package lesson16.utils;

import java.util.Scanner;

/**
 * Class ScannerController
 *
 * Contains methods to check correct input from Scanner.
 */
public class ScannerController {
    private final static Scanner sc = new Scanner(System.in);

    public static int scanCorrectIntValue(int minVal, int maxVal, String preInputMsg) {
        int tmp;
        do {
            System.out.print(preInputMsg + "(" + minVal + "-" + maxVal + "):");
            if(sc.hasNextInt()) {
                tmp = sc.nextInt();
                if(tmp >= minVal && tmp <= maxVal) { // leave infinite loop if correct value
                    break;
                }
            } else { // bad input
                sc.next();
            }
            System.out.println("Bad input! Try again!");
        }
        while(true);
        return tmp;
    }
}
