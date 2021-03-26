package com.storozhuk.lesson3;

/*
 * Tasks 6
 *
 * Printing first 10 values of sequence 0, -5, -10..
 */

public class Sequence {
    public static void main(String[] args) {
        int n = 0;
        for(int i = 0; i<10; i++) {
            System.out.print(n + " ");
            n -= 5;
        }
    }
}
