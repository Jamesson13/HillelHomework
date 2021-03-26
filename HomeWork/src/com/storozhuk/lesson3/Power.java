package com.storozhuk.lesson3;

/*
 * Tasks 5
 *
 * Calculating n-th power of x ( x^n )
 * where n >= 0
 */

import java.util.Scanner;

public class Power {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, n;
        int pow;

        System.out.print("Enter x:");
        x = sc.nextInt();
        System.out.print("Enter n:");
        n = sc.nextInt();

        if(n < 0) {
            System.out.println("n must be positive or equals to 0");
            return;
        }

        pow = 1;
        for(int i = 1; i <= n; i++) {
            pow *= x;
        }

        System.out.println(x + "^" + n + " = " + pow);
    }
}
