package com.storozhuk.lesson2;

/*
 * Counting the average of any numbers
 */

public class Task2 {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Too few arguments.");
            return;
        }

        double argsSum = 0d;
        int argCount = 0;

        for(String arg : args) {
            argCount++;
            argsSum += Double.parseDouble(arg);
            System.out.printf("Value #%d: %s\n", argCount, arg);
        }

        System.out.println("\nAverage: " + argsSum/argCount);
    }
}