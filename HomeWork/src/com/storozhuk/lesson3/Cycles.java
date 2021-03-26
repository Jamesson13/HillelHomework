package com.storozhuk.lesson3;

/*
 * Tasks 1-4
 *
 * Printing odd values from 1 to 99
 * and calculating factorial of input value using for/while/do...while cycles
 */

import java.util.Scanner;

public class Cycles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;

        System.out.print("Your input:");
        input = sc.nextInt();

        System.out.println("\"For\" cycle usage:");
        printOddFor(1, 99);
        calcFactorialFor(input);
        System.out.println("-------------------------------------------\n");

        System.out.println("\"While\" cycle usage:");
        printOddWhile(1, 99);
        calcFactorialWhile(input);
        System.out.println("-------------------------------------------\n");

        System.out.println("\"Do...While\" cycle usage:");
        printOddDoWhile(1, 99);
        calcFactorialDoWhile(input);
    }

    /* Printing odd numbers using "For" cycle */
    private static void printOddFor(int start, int end) {
        for(int i = start; i <= end; i++) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.print("\n");
    }

    /* Calculating factorial of n using "for" cycle */
    private static void calcFactorialFor(int n) {
        int factorial = 1;

        if(n < 0) {
            System.out.println("Bad input, please try again!");
            return;
        }

        for(int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("n = " + n);
        System.out.println("n! = " + factorial);
    }

    /* Printing odd numbers using "While" cycle */
    private static void printOddWhile(int start, int end) {
        int i = start;

        while(i <= end) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
            i++;
        }
        System.out.print("\n");
    }

    /* Calculating factorial of n using "While" cycle */
    private static void calcFactorialWhile(int n) {
        int factorial = 1;
        int i = 1;

        if(n < 0) {
            System.out.println("Bad input, please try again!");
            return;
        }

        while(i <= n) {
            factorial *= i;
            i++;
        }

        System.out.println("n = " + n);
        System.out.println("n! = " + factorial);
    }

    /* Printing odd numbers using "Do...While" cycle */
    private static void printOddDoWhile(int start, int end) {
        int i = start;

        do {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
            i++;
        } while(i <= end);
        System.out.print("\n");
    }

    /* Calculating factorial of n using "Do...While" cycle */
    private static void calcFactorialDoWhile(int n) {
        int factorial = 1;
        int i = 1;

        if(n < 0) {
            System.out.println("Bad input, please try again!");
            return;
        }

        do {
            factorial *= i;
            i++;
        } while(i <= n);

        System.out.println("n = " + n);
        System.out.println("n! = " + factorial);
    }
}