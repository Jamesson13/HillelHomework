package com.storozhuk.lesson3;

/*
 * Tasks 7
 *
 * Printing multiplication table of X
 */

import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x;

        System.out.print("Enter X:");
        x = sc.nextInt();

        for(int i = 1; i <= 10; i++) {
            System.out.println(x + " * " + i + " = " + (x*i));
        }
    }
}
