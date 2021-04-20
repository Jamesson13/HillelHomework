package com.storozhuk.lesson10;

import java.util.Arrays;
import java.util.Scanner;

import static com.storozhuk.lesson10.service.QuadraticEquation.getRoots;

/*
 * Написать программу для вычисления корней квадратного уравнения.
 */
public class Roots {
    public static void main(String[] args) {
        System.out.println("\nTask3. Quadratic equation:");
        for(int i = 0; i < 3; i++) {
            System.out.println("\nEnter a, b, c for equation ax2+bx+c=0 :");
            Scanner sc = new Scanner(System.in);
            System.out.print("a=");
            double a = sc.nextDouble();
            System.out.print("b=");
            double b = sc.nextDouble();
            System.out.print("c=");
            double c = sc.nextDouble();

            System.out.println("Result: " + Arrays.toString(getRoots(a, b, c)));
        }
    }
}
