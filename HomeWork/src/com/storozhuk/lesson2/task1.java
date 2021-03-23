package com.storozhuk.lesson2;

/*
 * Counting the average of two numbers
 */

public class task1 {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Invalid arguments count: " + args.length);
            return;
        }

        double val1 = Double.parseDouble(args[0]);
        double val2 = Double.parseDouble(args[1]);

        System.out.println("Value #1: " + val1);
        System.out.println("Value #2: " + val2);
        System.out.println("\nAverage: " + (val1+val2)/2);
    }
}