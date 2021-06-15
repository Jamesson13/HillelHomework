package lesson16.utils;

import java.util.Scanner;

/**
 * Class ScannerController
 *
 * @author Oleksandr Storozhuk
 * @version 1.0.0
 * created on 21.05.2021
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
                    return tmp;
                }
            } else { // bad input
                sc.next();
            }
            System.out.println("Bad input! Try again!");
        }
        while(true);
    }

    public static String scanLine(int maxLen, String preInputMsg) {
        String tmp;
        // skip previous input if exists
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        do {
            System.out.print(preInputMsg + "(maxLen=" + maxLen + "):");
            tmp = sc.nextLine();

            if(tmp.length() <= maxLen) { // leave infinite loop if correct value
                 return tmp;
            }
            System.out.println("Bad input! Try again!");
        }
        while(true);
    }
}