package lesson14;

import lesson14.service.dto.Font;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Class GraphicGenerator
 *
 * Contains method to generate and print pseudo-graphics into console output.
 */
public class GraphicGenerator {

    public static void main(String[] args) {
        System.out.print("Enter your number:");
        GraphicGenerator.print(new Scanner(System.in).next(), Font.atBold);
    }

    /* Print pseudo-graphic in console window */
    public static void print(String num, String[] font) {
        if(num.matches("\\d+")) {

            // make array of digits
            String[][] graphics = splitGraphics(font);

            // print
            Arrays.stream(graphics).forEach((gr) -> {
                Arrays.stream(splitStringToNumbers(num))
                        .forEach((n) -> System.out.print(gr[n] + " "));
                System.out.println();
            });
        }
    }

    /* Split font array into an array of characters */
    private static String[][] splitGraphics(String[] font) {
        int height = font.length;
        int width = (font[0].length() - 9) / 10;
        String[][] table = new String[height][10];

        for(int digit = 0; digit < 10; digit++) {
            for(int line = 0; line < height; line++) {
                table[line][digit] = font[line].substring(
                        digit * (width + 1),
                        (digit + 1) * (width + 1) - 1);
            }
        }
        return table;
    }

    /* Split string into array of digits */
    private static int[] splitStringToNumbers(String num) {
        return Arrays.stream(num.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
