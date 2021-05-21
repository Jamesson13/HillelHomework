package lesson16.utils;

import java.util.Random;

/**
 * Class RandomGenerator
 *
 * Contains methods to get random values within needed diapason.
 */
public class RandomGenerator {
    static Random random = new Random();

    public static int getRandomInt(int min, int max) {
        return (random.nextInt(max - min + 1) + min);
    }
}
