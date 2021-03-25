package com.storozhuk.lesson2;

/*
 * Deposit calculation with monthly capitalization
 */

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double percentsPerYear, percentsPerMonth;

        System.out.print("Enter deposit amount:");
        double depositAmount = input.nextDouble();

        System.out.print("Enter deposit rate %:");
        double depositRate = input.nextDouble();

        System.out.print("Enter deposit term (in years):");
        int depositTerm = input.nextInt();

        if(depositAmount < 0 || depositRate < 1 || depositTerm < 1) {
            System.out.print("Incorrect input. Please retry.");
            return;
        }

        for (int y = 1; y <= depositTerm; y++ ) {
            percentsPerYear = 0d;
            for (int m = 0; m < 12; m++) {
                percentsPerMonth = depositAmount*depositRate/100d/12d;
                percentsPerYear += percentsPerMonth;
                depositAmount += percentsPerMonth;
            }
            System.out.print("\n\nYear: " + y);
            System.out.print("\nPercentages per current year: " + String.format("%.2f",percentsPerYear) + "UAH");
            System.out.print("\nTotal deposit amount: " + String.format("%.2f",depositAmount) + "UAH");
        }
    }
}
